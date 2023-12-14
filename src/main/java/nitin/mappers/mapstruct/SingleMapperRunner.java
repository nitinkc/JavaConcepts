package nitin.mappers.mapstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import nitin.mappers.mapstruct.dto.EmployeeDto;
import nitin.mappers.mapstruct.mapper.EmployeeMapper;
import nitin.mappers.mapstruct.model.Employee;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.net.URL;
import java.util.stream.Collectors;

public class SingleMapperRunner {
    public static void main(String[] args) throws IOException {
        final EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

        URL resource = new URL("file:src/main/resources/json/single-a5object-mapper.json");
        ObjectMapper om = new ObjectMapper();

        //Convert this to CompletableFuturesSingleMapperRunner
        Employee employee = om.readValue(resource, Employee.class);
        checkIfNeeded(employee);

        EmployeeDto employeeDto = mapper.employeeToEmployeeDto(employee);
        System.out.println(employeeDto.toString());
    }

    private static void checkIfNeeded(Employee employee) {
        //Removing the empty addresses
        employee.setAddresses(employee.getAddresses().stream()
                        .filter(singleAddress -> (
                                null != singleAddress.getAddressLine1() ||
                                null != singleAddress.getAddressLine2() ||
                                null != singleAddress.getCity() ||
                                null != singleAddress.getState() ||
                                null != singleAddress.getZip()
                        )).collect(Collectors.toList()));

        //String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        //System.out.println(jsonString);
    }
}
