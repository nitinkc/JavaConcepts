
package nitin.whyItsWorking.example;

import lombok.*;

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
