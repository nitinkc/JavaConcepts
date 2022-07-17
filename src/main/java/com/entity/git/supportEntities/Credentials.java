package com.entity.git.supportEntities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "token",
        "expires"
})
@Generated("jsonschema2pojo")
public class Credentials {

    @JsonProperty("token")
    public String token;
    @JsonProperty("expires")
    public Boolean expires;

}