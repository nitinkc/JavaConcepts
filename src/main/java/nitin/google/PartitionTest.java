package nitin.google;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class PartitionTest {
    public static void main(String[] args) {
        List<List<Integer>> partition= Lists.partition(Arrays.asList(1,2,3,4,5,6,78,8,9,10,234),3);

        System.out.println(partition);
    }
}
