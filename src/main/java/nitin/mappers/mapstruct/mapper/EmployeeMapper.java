package nitin.mappers.mapstruct.mapper;

import nitin.mappers.mapstruct.dto.EmployeeDto;
import nitin.mappers.mapstruct.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {
    @Mapping(target="employeeName", source="entity.name")
    @Mapping(target="dateOfBirth", source="entity.dob")
    @Mapping(target = "phones", source = "entity.phones")
    @Mapping(target = "addresses", source = "entity.addresses")
    EmployeeDto employeeToEmployeeDto(Employee entity);//This will be implemented by MapStruct

    /*
    Employee employeeDTOtoEmployee(EmployeeDto dto);
    */
}
