package nitin.mappers.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nitin.mappers.jackson.model.Address;
import nitin.mappers.jackson.model.Employee;

import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMapperRunner {
    public static void main(String[] args) throws IOException {
        URL resource = new URL("file:src/main/resources/json/single-object-mapper.json");
        ObjectMapper om = new ObjectMapper();


        //directJavaObject();
       // jsonFromFile();
        typeRefForMap(om,resource);
    }

    private static void jsonFromFile() throws IOException {
        URL resource = new URL("file:src/main/resources/json/single-object-mapper.json");
        ObjectMapper om = new ObjectMapper();

        Employee employee = om.readValue(resource, Employee.class);

        //Removing the empty addresses
        employee.setAddresses(filterEmptyObjects(employee.getAddresses()));

        String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        System.out.println(jsonString);
    }

    private static List<Address> filterEmptyObjects(List<Address> addresses) {
        addresses = addresses.stream()
                .filter(singleAddress -> {
                    return nullAddressFilter(singleAddress);
                })
                .collect(Collectors.toList());
        return addresses;
    }

    private static boolean nullAddressFilter(Address singleAddress) {
        return (null != singleAddress.getAddressLine1() ||
                null != singleAddress.getAddressLine2() ||
                null != singleAddress.getCity() ||
                null != singleAddress.getState() ||
                null != singleAddress.getZip()
        );
    }

    private static void directJavaObject() throws JsonProcessingException {
        Employee employee = Employee.builder()
                .name("Jane")
                .dob(Date.from(ZonedDateTime.now().plusDays(1).toInstant()))
                .phones(Map.of("Mobile","123-456-7890", "Work", "(222) 222 2222"))
                .addresses(List.of(Address.builder().build()))
                .build();

        ObjectMapper om = new ObjectMapper();
        //String jsonString = om.writeValueAsString(employee);
        String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(employee);

        System.out.println(jsonString);
    }

    private static void typeRefForMap(ObjectMapper objectMapper, URL url) throws IOException {
        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<HashMap<String,Object>>() {};

        HashMap<String, Object> employees = objectMapper.readValue(url, typeRef);

        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
        System.out.println(jsonString);
    }
}