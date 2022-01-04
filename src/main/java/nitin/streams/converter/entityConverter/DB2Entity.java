package nitin.streams.converter.entityConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

@AllArgsConstructor
@Data
public class DB2Entity {
    private Boolean isAutoFlowRate;
    private Double autoFlowRateRatio;
}
