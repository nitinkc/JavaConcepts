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
        "date-parts"
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Issued {

    @JsonProperty("date-parts")
    public List<List<Integer>> dateParts = null;

}
