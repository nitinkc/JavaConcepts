package com.entity.currencyExchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "motd",
        "success",
        "query",
        "info",
        "historical",
        "date",
        "result"
})
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CurrencyExchange {

    @JsonProperty("motd")
    public Motd motd;
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("query")
    public Query query;
    @JsonProperty("info")
    public Info info;
    @JsonProperty("historical")
    public Boolean historical;
    @JsonProperty("date")
    public String date;
    @JsonProperty("result")
    public Float result;
}