
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
    "start-index",
    "search-terms"
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Query {

    @JsonProperty("start-index")
    public Integer startIndex;
    @JsonProperty("search-terms")
    public Object searchTerms;

}
