package nitin.mappers.mapstruct.dto;

import lombok.*;
import nitin.mappers.mapstruct.model.Address;

import java.util.Date;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class EmployeeDto {
    private String employeeName;
    private Date dateOfBirth;
    private Map<String, String> phones;
    private List<Address> addresses;
}
