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
        "facets",
        "total-results",
        "items",
        "items-per-page",
        "query"
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {

    @JsonProperty("facets")
    public Facets facets;
    @JsonProperty("total-results")
    public Integer totalResults;
    @JsonProperty("items")
    public List<Item> items = null;
    @JsonProperty("items-per-page")
    public Integer itemsPerPage;
    @JsonProperty("query")
    public Query query;

}
