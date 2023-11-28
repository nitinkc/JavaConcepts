package nitin.whyItsWorking.example;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data

public class Report {
    public Boolean labsData;
    public List<Labs> labs;
}