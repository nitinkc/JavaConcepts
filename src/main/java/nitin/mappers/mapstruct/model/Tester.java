package nitin.mappers.mapstruct.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
