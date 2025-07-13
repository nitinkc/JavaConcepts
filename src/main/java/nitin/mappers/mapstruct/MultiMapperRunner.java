package nitin.mappers.mapstruct;

import com.entity.Beer;
import com.entity.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utilities.InternetUtilities;
import com.utilities.RestGETReadUtility;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import nitin.mappers.mapstruct.dto.PersonDto;
import nitin.mappers.mapstruct.mapper.PersonMapper;
import nitin.mappers.mapstruct.model.Employee;
import org.mapstruct.factory.Mappers;

public class MultiMapperRunner {
    public static void main(String[] args) throws IOException {
        final PersonMapper mapper = Mappers.getMapper(PersonMapper.class);

        URL resource = new URL("file:src/main/resources/json/single-a5object-mapper.json");
        ObjectMapper om = new ObjectMapper();

        // Convert this to CompletableFuturesSingleMapperRunner
        CompletableFuture<Employee> employee =
                CompletableFuture.supplyAsync(() -> getEmployee(resource, om));
        CompletableFuture<List<Beer>> beers =
                CompletableFuture.supplyAsync(() -> InternetUtilities.getBeers(2));
        CompletableFuture<List<Vehicle>> vehicles =
                CompletableFuture.supplyAsync(() -> RestGETReadUtility.getRandomVehicles(2));

        PersonDto personDto =
                mapper.personMapper(employee.join(), beers.join().get(0), vehicles.join().get(0));

        System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(personDto));
    }

    private static Employee getEmployee(URL resource, ObjectMapper om) {
        Employee employee = new Employee();
        try {
            employee = om.readValue(resource, Employee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employee;
    }

    private static void checkIfNeeded(Employee employee) {
        // Removing the empty addresses
        employee.setAddresses(
                employee.getAddresses().stream()
                        .filter(
                                singleAddress ->
                                        (null != singleAddress.getAddressLine1()
                                                || null != singleAddress.getAddressLine2()
                                                || null != singleAddress.getCity()
                                                || null != singleAddress.getState()
                                                || null != singleAddress.getZip()))
                        .collect(Collectors.toList()));

        // String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        // System.out.println(jsonString);
    }
}
