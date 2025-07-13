package nitin.streams.collectors.whyItsWorking.example;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CareCategory {
    public String labTestName;
    public List<CurrentMonth> currentMonth;
    public List<PreviousMonth> previousMonth;
    public List<SecondPreviousMonth> secondPreviousMonth;
}
