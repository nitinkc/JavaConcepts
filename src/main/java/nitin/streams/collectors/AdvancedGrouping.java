package nitin.streams.collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import nitin.streams.collectors.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.utilities.JsonUtils.getJsonStringFromFile;

@Slf4j
public class AdvancedGrouping {
    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        List<Map<String, Object>> data = new ArrayList<>();
        try {
            String response = getJsonStringFromFile("src/main/resources/json/groupingBy.json");
            data = mapper.readValue(response, new TypeReference<>() {
            });
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        List<Map<String, Object>> finalJson = generateCrossTab(data);

        try {
            String writeValueAsString = new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                    .setSerializationInclusion(JsonInclude.Include.ALWAYS)
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(finalJson);
            System.out.println(writeValueAsString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Map<String, Object>> generateCrossTab(List<Map<String, Object>> data) {
        List<Header> header = findLast13Months();

        Map<String, ?> dto = null;
        List<? extends LabBase> labs = null;//list that contains elements of a type that is either LabBase or any subtype of LabBase
        Function<List<? extends LabBase>, Map<String, LabDetail>> buildLabDetailsMap = null;

        List<AdditionalLab> additionalLabsDto = mapper.convertValue(data, new TypeReference<List<AdditionalLab>>() {
        });
        labs = additionalLabsDto;

        return getMaps(labs, header);
    }

    public static List<Map<String, Object>> generateCrossTabPdf(List<? extends LabBase> labs) {
        List<Header> header = findLast13Months();
        return getMaps(labs, header);
    }


    private static List<Map<String, Object>> getMaps(List<? extends LabBase> labs, List<Header> header) {
        Function<List<? extends LabBase>, Map<String, LabDetail>> buildLabDetailsMap;
        buildLabDetailsMap = AdvancedGrouping::buildLabDetailsMap;

        List<Map<String, Object>> returnList = getCrossTabMaps(labs, buildLabDetailsMap, header);
        return returnList;
    }

    private static List<Map<String, Object>> getCrossTabMaps(List<? extends LabBase> labs,
                                                             Function<List<? extends LabBase>, Map<String, LabDetail>> buildLabDetailsMap,
                                                             List<Header> header) {

        labs.sort(Comparator
                .comparing(LabBase::getSortOrder, Comparator.naturalOrder())
                .thenComparing(LabBase::getDateTime, Comparator.reverseOrder()));

        Map<String, LabDetail> labDetailsMap = buildLabDetailsMap.apply(labs);

        CrossTable crossTable = CrossTable.builder()
                .header(header)
                .labDetails(new ArrayList<>(labDetailsMap.values()))
                .build();
        Map<String, Object> additionalLabsMap = mapper.convertValue(crossTable, new TypeReference<Map<String, Object>>() {
        });

        List<Map<String, Object>> returnList = new ArrayList<>();
        returnList.add(additionalLabsMap);
        return returnList;
    }

    private static Map<String, LabDetail> buildLabDetailsMap(List<? extends LabBase> labs) {
        // Group model labs by name and uom and maintain insertion order
        return labs.stream()
                .collect(Collectors.groupingBy(lab -> lab.getName() + lab.getUom(),//Key for the Map
                                LinkedHashMap::new, // Use LinkedHashMap as the Map implementation
                                Collectors.collectingAndThen(
                                        Collectors.toList(), list -> {
                                            LabBase base = list.get(0); // Assuming first element is representative
                                            return LabDetail.builder()
                                                    .name(base.getName())
                                                    .uom(base.getUom())
                                                    .sortOrder(base.getSortOrder())
                                                    .labs(createLabDataForEachRow(list))
                                                    .build();
                                        }
                                )
                        )
                );
    }

    private static List<Lab> createLabDataForEachRow(List<? extends LabBase> labs) {
        List<Lab> labDataList = new ArrayList<>();
        LocalDate currentMonth = LocalDate.now();

        for (int i = 0; i < 13; i++) {
            LocalDate month = currentMonth.minusMonths(i);
            String monthString = month.format(DateTimeFormatter.ofPattern("MMM yyyy"));
            List<? extends LabBase> labsForMonth = labs.stream()
                    .filter(lab -> lab.getDateTime().getMonth().equals(month.getMonth()) &&
                            lab.getDateTime().getYear() == month.getYear())
                    .collect(Collectors.toList());

            Lab lab = Lab.builder()
                    .month(monthString)
                    .labsData(createLabsData(labsForMonth))
                    .build();

            labDataList.add(lab);
        }
        return labDataList;
    }

    private static List<LabsDatum> createLabsData(List<? extends LabBase> labs) {
        return labs.stream()
                .map(lab -> {
                    LabsDatum labsDatum = new LabsDatum();
                    labsDatum.setValue(lab.getValue());
                    return labsDatum;
                })
                .collect(Collectors.toList());
    }

    private static List<Header> findLast13Months() {
        List<Header> header = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM yyyy");

        header.add(Header.builder().value(currentDate.format(formatter)).build());

        for (int i = 1; i < 13; i++) {
            LocalDate previousMonth = currentDate.minusMonths(i);
            String formatted = previousMonth.format(formatter);
            header.add(Header.builder().value(formatted).build());
        }

        return header;
    }
}