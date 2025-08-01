package nitin.mappers.mapstruct.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.*;
import nitin.mappers.jackson.model.Address;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Employee {
    @JsonProperty("name")
    private String name;

    @JsonProperty("dateOfBirth")
    private Date dob;

    @JsonProperty("phones")
    private Map<String, String> phones;

    @JsonProperty("addresses")
    private List<Address> addresses;

    private String nullTester;
}
