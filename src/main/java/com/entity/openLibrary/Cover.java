package com.entity.openLibrary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "small",
        "medium",
        "large"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cover {

    @JsonProperty("small")
    public String small;
    @JsonProperty("medium")
    public String medium;
    @JsonProperty("large")
    public String large;

}
