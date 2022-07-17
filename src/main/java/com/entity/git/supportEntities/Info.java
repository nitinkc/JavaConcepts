package com.entity.git.supportEntities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.processing.Generated;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nickname",
        "email",
        "name",
        "image",
        "urls"
})
@Generated("jsonschema2pojo")
public class Info {

    @JsonProperty("nickname")
    public String nickname;
    @JsonProperty("email")
    public String email;
    @JsonProperty("name")
    public String name;
    @JsonProperty("image")
    public String image;
    @JsonProperty("urls")
    public Urls urls;
}
