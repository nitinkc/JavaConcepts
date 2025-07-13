package nitin.streams.collectors.whyItsWorking.example;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Labs {
    public String careCategoryName;
    public String currentMonthName;
    public String previousMonthName;
    public String secondPreviousMonthName;
    public List<CareCategory> careCategory;
}
