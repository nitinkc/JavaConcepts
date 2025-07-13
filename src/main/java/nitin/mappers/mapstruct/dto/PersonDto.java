package nitin.mappers.mapstruct.dto;

import java.util.List;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class PersonDto {
    private String employeeFirstName;
    private String employeeLastName;
    private String birthDate;
    private List<String> phones; // From Map to List
    // Beer
    private String beerBrand;
    private String beerName;
    private String alcohol;
    // Vehicle
    private String carMakeAndModel;
    private String carColor;
    private String driveType;
    private String fuelType;
    private List<String> specs;
    private Integer doors;
    private String licensePlate;
    // Testing Null Field
    private String extraField;
}
