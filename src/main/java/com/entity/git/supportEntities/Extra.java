package com.entity.git.supportEntities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"raw_info"})
@Generated("jsonschema2pojo")
public class Extra {

    @JsonProperty("raw_info")
    public RawInfo rawInfo;
}
