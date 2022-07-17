package com.entity.git;

import com.entity.git.supportEntities.Credentials;
import com.entity.git.supportEntities.Extra;
import com.entity.git.supportEntities.Info;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "provider",
        "uid",
        "info",
        "credentials",
        "extra"
})
@Generated("jsonschema2pojo")
public class GitUser {

    @JsonProperty("provider")
    public String provider;
    @JsonProperty("uid")
    public String uid;
    @JsonProperty("info")
    public Info info;
    @JsonProperty("credentials")
    public Credentials credentials;
    @JsonProperty("extra")
    public Extra extra;

}
