package com.entity.openLibrary;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"lc_classifications", "dewey_decimal_class"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Classifications {

    @JsonProperty("lc_classifications")
    public List<String> lcClassifications = null;

    @JsonProperty("dewey_decimal_class")
    public List<String> deweyDecimalClass = null;
}
