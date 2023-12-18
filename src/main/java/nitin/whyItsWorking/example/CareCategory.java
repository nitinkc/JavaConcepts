
package nitin.whyItsWorking.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
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
