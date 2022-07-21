package com.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class VehicleTransformed {
    private Integer id;
    private String uid;
    private String vin;
    private String makeAndModel;
    private String color;
    private String transmission;
    private String driveType;
    private String fuelType;
    private String carType;
    private String carOptions;//Transforming from List of Strings into semi-colon separated String
    private String specs;//Transforming from List of Strings into semi-colon separated String
    private Integer doors;
    private Integer mileage;
    private Integer kilometrage;
    private String licensePlate;
}
