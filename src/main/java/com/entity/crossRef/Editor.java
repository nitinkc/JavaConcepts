
package com.entity.crossRef;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "given",
    "family",
    "sequence",
    "affiliation"
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Editor {

    @JsonProperty("given")
    public String given;
    @JsonProperty("family")
    public String family;
    @JsonProperty("sequence")
    public String sequence;
    @JsonProperty("affiliation")
    public List<Object> affiliation = null;

}
