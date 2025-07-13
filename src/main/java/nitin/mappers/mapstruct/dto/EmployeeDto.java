package nitin.mappers.mapstruct.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.*;
import nitin.mappers.mapstruct.model.Address;

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
