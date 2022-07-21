
package com.entity.crossRef;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "URL",
    "content-type",
    "content-version",
    "intended-application"
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Link {

    @JsonProperty("URL")
    public String url;
    @JsonProperty("content-type")
    public String contentType;
    @JsonProperty("content-version")
    public String contentVersion;
    @JsonProperty("intended-application")
    public String intendedApplication;

}
