package com.entity.crossRef;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"date-parts"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublishedOnline {

    @JsonProperty("date-parts")
    public List<List<Integer>> dateParts = null;
}
