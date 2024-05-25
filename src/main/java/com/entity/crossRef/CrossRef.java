package com.entity.crossRef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "message-type",
        "message-version",
        "message"
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrossRef {

    @JsonProperty("status")
    public String status;
    @JsonProperty("message-type")
    public String messageType;
    @JsonProperty("message-version")
    public String messageVersion;
    @JsonProperty("message")
    public Message message;

}
