package nitin.streams.fileStreams;

import com.entity.Cancer;
import com.utilities.CsvReadUtility;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Created by nichaurasia on Tuesday, January/28/2020 at 3:55 PM */
public class FileStream {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<Cancer> list = CsvReadUtility.getCancerData();

        Map<Integer, List<Cancer>> map =
                list.stream().collect(Collectors.groupingBy(Cancer::getYear));

        for (Map.Entry<Integer, List<Cancer>> itr : map.entrySet()) {
            System.out.println(
                    "Key: " + itr.getKey() + "== Value: " + itr.getValue().stream().count());
        }

        Map<String, List<Cancer>> map2 =
                list.stream().collect(Collectors.groupingBy(Cancer::getState));

        for (Map.Entry<String, List<Cancer>> itr : map2.entrySet()) {
            System.out.println(
                    "Key: " + itr.getKey() + "== Value: " + itr.getValue().stream().count());
        }
    }
}
