package nitin.mappers.jackson.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import nitin.mappers.jackson.filter.DoorFilter;
import nitin.mappers.jackson.filter.EmptyListFilter;
import nitin.mappers.jackson.filter.LicenseFilter;
import nitin.mappers.jackson.filter.PhoneFilter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RandomVehicle {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("vin")
    private String vin;
    @JsonProperty("make_and_model")
    @JsonInclude(content = JsonInclude.Include.CUSTOM, contentFilter = PhoneFilter.class)
    private String makeAndModel;
    @JsonProperty("color")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String color;
    @JsonProperty("transmission")
    private String transmission;
    @JsonProperty("drive_type")
    private String driveType;
    @JsonProperty("fuel_type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fuelType;
    @JsonProperty("car_type")
    private String carType;
    @JsonProperty("car_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> carOptions;
    @JsonProperty("specs")
    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = EmptyListFilter.class)
    private List<String> specs;
    @JsonProperty("doors")
    @JsonInclude(content = JsonInclude.Include.CUSTOM, valueFilter = DoorFilter.class)
    private Integer doors;
    @JsonProperty("mileage")
    private Integer mileage;
    @JsonProperty("kilometrage")
    private Integer kilometer_range;
    @JsonProperty("license_plate")
    //@JsonInclude(content = JsonInclude.Include.CUSTOM, contentFilter = LicenseFilter.class)
    @JsonInclude(content = JsonInclude.Include.CUSTOM, valueFilter = LicenseFilter.class)
    private String licensePlate;
}