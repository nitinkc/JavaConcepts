package nitin.virtualThreads.v6DelimitedContinuations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Incrementer {
    int counter;
    String timeOfIncrement;
}