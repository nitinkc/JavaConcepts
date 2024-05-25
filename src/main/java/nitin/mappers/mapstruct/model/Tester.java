package nitin.mappers.mapstruct.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Tester {
    @JsonProperty("tester")
    private Double test;
    @JsonProperty("testerList")
    private List<Double> testList;

}