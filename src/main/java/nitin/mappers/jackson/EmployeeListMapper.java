package nitin.mappers.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nitin.mappers.jackson.model.Address;
import nitin.mappers.jackson.model.Employee;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeListMapper {
    public static void main(String[] args) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();

        URL url = new URL("file:src/main/resources/json/array-object-mapper.json");

        //typeRefForArray(objectMapper, url);
        typeRefForListOfMap(objectMapper, url);


    }

    private static void typeRefForListOfMap(ObjectMapper objectMapper, URL url) throws IOException {
        //File from = new File("src/main/resources/json/array-object-mapper.json");
        //File from = new File("src/main/resources/json/single-object-mapper.json");

        TypeReference<List<HashMap<String,Object>>> typeRef
                = new TypeReference<List<HashMap<String,Object>>>() {};

        List<HashMap<String, Object>> employees = objectMapper.readValue(url, typeRef);
//        for(Employee employee : employees){
//            //Removing the empty addresses
//            employee.setAddresses(filterEmptyObjects(employee.getAddresses()));
//        }

        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
        System.out.println(jsonString);
    }

    private static void typeRefForArray(ObjectMapper objectMapper, URL url) throws IOException {
        final List<Employee> employees = objectMapper.readValue(url, new TypeReference<List<Employee>>() {});
        for(Employee employee : employees){
            //Removing the empty addresses
            employee.setAddresses(filterEmptyObjects(employee.getAddresses()));
        }

        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
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

}
