package com.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import javax.annotation.processing.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "uid",
    "vin",
    "make_and_model",
    "color",
    "transmission",
    "drive_type",
    "fuel_type",
    "car_type",
    "car_options",
    "specs",
    "doors",
    "mileage",
    "kilometrage",
    "license_plate"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@ToString
public class Vehicle {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("vin")
    private String vin;

    @JsonProperty("make_and_model")
    private String makeAndModel;

    @JsonProperty("color")
    private String color;

    @JsonProperty("transmission")
    private String transmission;

    @JsonProperty("drive_type")
    private String driveType;

    @JsonProperty("fuel_type")
    private String fuelType;

    @JsonProperty("car_type")
    private String carType;

    @JsonProperty("car_options")
    private List<String> carOptions = null;

    @JsonProperty("specs")
    private List<String> specs = null;

    @JsonProperty("doors")
    private Integer doors;

    @JsonProperty("mileage")
    private Integer mileage;

    @JsonProperty("kilometrage")
    private Integer kilometrage;

    @JsonProperty("license_plate")
    private String licensePlate;
}
