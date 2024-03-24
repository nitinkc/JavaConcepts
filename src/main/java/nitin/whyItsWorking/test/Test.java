package nitin.whyItsWorking.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import nitin.whyItsWorking.example.CareCategory;
import nitin.whyItsWorking.example.Example;
import nitin.whyItsWorking.example.Labs;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    static final List<String> ANEMIA_LABS = Arrays.asList("HEMOGLOBIN (g/dL)",
            "IRON SATURATION (%)",
            "FERRITIN (ng/mL)",
            "IRON (ug/dL)",
            "MCV (fL)",
            "RETIC COUNT (%)",
            "ABSOLUTE RETIC COUNT (x 10'6 cells/uL)",
            "WBC (x 10'3 cells/uL)");

    public static void main(String[] args) {
        Example example = getData();

        Map<String, Boolean> anemiaLabsMap = new HashMap<>();
        for (String lab : ANEMIA_LABS) {
            anemiaLabsMap.put(lab, false);
        }


        List<Labs> labsAnemiaAndOther = example.getReport().getLabs();
        List<Labs> anemiaLabs = labsAnemiaAndOther
                .stream()
                .filter(allLabs -> allLabs.getCareCategoryName().equalsIgnoreCase("Anemia"))
                .toList();

        List<CareCategory> anemiaCareCategory = anemiaLabs.get(0).getCareCategory();//Add the empty labs in this

        if(anemiaCareCategory.size() != ANEMIA_LABS.size()) {//8 Anemia labs hardcoded if all 8 are present, send as is, else fill with empty
            for (CareCategory singleCareCategory : anemiaCareCategory) {
                //Fill the Anemia Labs map to find the delta
                anemiaLabsMap.put(singleCareCategory.getLabTestName(), Boolean.TRUE);
            }
        }

        //Put care category for false value of key labs
        // Iterate through the map entries
        for (Map.Entry<String, Boolean> entry : anemiaLabsMap.entrySet()) {
            String labTest = entry.getKey();
            Boolean isAnemic = entry.getValue();
            // Check if the value is false
            if (!isAnemic) {
                CareCategory careCategoryDTO =  CareCategory.builder()
                        .labTestName(labTest)
                        .currentMonth(List.of())
                        .previousMonth(List.of())
                        .secondPreviousMonth(List.of())
                        .build();
                anemiaCareCategory.add(careCategoryDTO);
            }
        }

        System.out.println(example);
    }

    private static Example getData() {
        String response = null;
        ObjectMapper mapper = new ObjectMapper();

        Example example;
        URL resource;
        try {
            resource = new URL("file:src/main/resources/json/labs.json");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try {
            example = mapper.readValue(resource, Example.class );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return example;
    }

    static String getJsonStringFromFile(String path) throws IOException {
        ClassLoader classLoader = Test.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            throw new IOException("Resource not found: " + path);
        }

        File file = new File(resource.getFile());
        return FileUtils.readFileToString(file, "UTF-8");
    }
}
