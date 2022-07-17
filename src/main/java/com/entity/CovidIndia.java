package com.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Country",
        "CountryCode",
        "Province",
        "City",
        "CityCode",
        "Lat",
        "Lon",
        "Confirmed",
        "Deaths",
        "Recovered",
        "Active",
        "Date"
})
@Generated("jsonschema2pojo")
@Getter
@Setter
@ToString
public class CovidIndia {
    @JsonProperty("Country")
    private String country;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("Province")
    private String province;
    @JsonProperty("City")
    private String city;
    @JsonProperty("CityCode")
    private String cityCode;
    @JsonProperty("Lat")
    private String lat;
    @JsonProperty("Lon")
    private String lon;
    @JsonProperty("Confirmed")
    private Integer confirmed;
    @JsonProperty("Deaths")
    private Integer deaths;
    @JsonProperty("Recovered")
    private Integer recovered;
    @JsonProperty("Active")
    private Integer active;
    @JsonProperty("Date")
    private String date;
}
