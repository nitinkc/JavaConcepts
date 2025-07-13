package nitin.streams.collectors.whyItsWorking.example;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Report {
    public Boolean labsData;
    public List<Labs> labs;
}
