package com.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
public class CovidIndia {
    @JsonProperty("Country")
    public String country;
    @JsonProperty("CountryCode")
    public String countryCode;
    @JsonProperty("Province")
    public String province;
    @JsonProperty("City")
    public String city;
    @JsonProperty("CityCode")
    public String cityCode;
    @JsonProperty("Lat")
    public String lat;
    @JsonProperty("Lon")
    public String lon;
    @JsonProperty("Confirmed")
    public Integer confirmed;
    @JsonProperty("Deaths")
    public Integer deaths;
    @JsonProperty("Recovered")
    public Integer recovered;
    @JsonProperty("Active")
    public Integer active;
    @JsonProperty("Date")
    public String date;
}
