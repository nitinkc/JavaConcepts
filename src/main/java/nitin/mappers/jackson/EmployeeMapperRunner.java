package nitin.mappers.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import nitin.mappers.jackson.model.Address;
import nitin.mappers.jackson.model.Employee;

public class EmployeeMapperRunner {
    static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
    }

    public static void main(String[] args) throws IOException {
        URL resource = new URL("file:src/main/resources/json/single-object-mapper.json");

        // NOT USING DTO's. Thus there are no convertors or mappers or transformers.
        jsonFromFile();
        //        directJavaObject();
        //        typeRefForMap(objectMapper,resource);
    }

    private static void jsonFromFile() throws IOException {
        URL resource = new URL("file:src/main/resources/json/single-object-mapper.json");

        List<Employee> employees =
                objectMapper.readValue(resource, new TypeReference<List<Employee>>() {});

        // Removing the empty addresses
        employees.forEach(
                eachEmployee ->
                        eachEmployee.setAddresses(filterEmptyObjects(eachEmployee.getAddresses())));

        Collections.sort(employees, Comparator.comparing(Employee::getDatelocaltzdt).reversed());

        String jsonString =
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
        System.out.println(jsonString);
    }

    private static List<Address> filterEmptyObjects(List<Address> addresses) {
        addresses =
                addresses.stream()
                        .filter(
                                singleAddress -> {
                                    return nullAddressFilter(singleAddress);
                                })
                        .collect(Collectors.toList());
        return addresses;
    }

    private static boolean nullAddressFilter(Address singleAddress) {
        return (null != singleAddress.getAddressLine1()
                || null != singleAddress.getAddressLine2()
                || null != singleAddress.getCity()
                || null != singleAddress.getState()
                || null != singleAddress.getZip());
    }

    private static void directJavaObject() throws JsonProcessingException {
        Employee employee =
                Employee.builder()
                        .name("Jane")
                        .dob(Date.from(ZonedDateTime.now().plusDays(1).toInstant()))
                        .datelocaltzdt(
                                LocalDateTime.parse(
                                        "2023-08-04T12:15:00",
                                        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))
                        .phones(Map.of("Mobile", "123-456-7890", "Work", "(222) 222 2222"))
                        .addresses(List.of(Address.builder().build()))
                        .build();

        // String jsonString = om.writeValueAsString(employee);
        String jsonString =
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);

        System.out.println(jsonString);
    }

    private static void typeRefForMap(ObjectMapper objectMapper, URL url) throws IOException {
        TypeReference<List<HashMap<String, Object>>> typeRef =
                new TypeReference<List<HashMap<String, Object>>>() {};

        List<HashMap<String, Object>> employees = objectMapper.readValue(url, typeRef);

        String jsonString =
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
        System.out.println(jsonString);
    }
}
