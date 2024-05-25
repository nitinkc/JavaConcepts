package nitin.streams.collectors.whyItsWorking.example;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data

public class Labs {
    public String careCategoryName;
    public String currentMonthName;
    public String previousMonthName;
    public String secondPreviousMonthName;
    public List<CareCategory> careCategory;
}
