package nitin.mappers.mapstruct.mapper;

import com.entity.Beer;
import com.entity.Vehicle;
import nitin.mappers.mapstruct.dto.PersonDto;
import nitin.mappers.mapstruct.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface PersonMapper {
    @Mapping(target="employeeFirstName", source="employee.name")
    @Mapping(target="employeeLastName", source="employee.name")
    @Mapping(target = "birthDate", source = "employee.dob", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "phones", source = "employee.phones", qualifiedByName = "processPhoneMap")//Map to List
    @Mapping(target = "beerBrand", source = "beer.brand")
    @Mapping(target = "beerName", source = "beer.name")
    @Mapping(target = "alcohol", source = "beer.alcohol")
    @Mapping(target = "carMakeAndModel", source = "vehicle.makeAndModel")
    @Mapping(target = "carColor", source = "vehicle.color")
    @Mapping(target = "driveType", source = "vehicle.driveType")
    @Mapping(target = "fuelType", source = "vehicle.fuelType")
    @Mapping(target = "specs", source = "vehicle.specs")
    @Mapping(target = "doors", source = "vehicle.doors")
    @Mapping(target = "licensePlate", source = "vehicle.licensePlate")
    @Mapping(target = "extraField", source = "employee.nullTester", defaultExpression = "java(com.github.javafaker.Faker.instance().chuckNorris().fact())")
    PersonDto personMapper(Employee employee, Beer beer, Vehicle vehicle);


    @Named("processPhoneMap")
    default List<String> processPhoneMap(Map<String, String> phoneMap) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : phoneMap.entrySet()){
            String key   = entry.getKey();
            String value = entry.getValue();
            list.add(key + " -> " + value);
        }
        return list;
    }
}