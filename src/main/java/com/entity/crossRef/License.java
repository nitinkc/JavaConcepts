package com.entity.crossRef;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"start", "content-version", "delay-in-days", "URL"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class License {

    @JsonProperty("start")
    public Start start;

    @JsonProperty("content-version")
    public String contentVersion;

    @JsonProperty("delay-in-days")
    public Integer delayInDays;

    @JsonProperty("URL")
    public String url;
}
