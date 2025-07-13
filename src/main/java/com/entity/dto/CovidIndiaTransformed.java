package com.entity.dto;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CovidIndiaTransformed {
    private String country;
    // public String countryCode;
    // public String province;
    // public String city;
    private String cityAndState;
    // public String cityCode;
    // public String lat; Not needed
    // public String lon;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private Integer active;
    private ZonedDateTime date;
}
