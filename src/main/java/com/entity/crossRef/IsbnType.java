package com.entity.crossRef;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"value", "type"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IsbnType {

    @JsonProperty("value")
    public String value;

    @JsonProperty("type")
    public String type;
}
