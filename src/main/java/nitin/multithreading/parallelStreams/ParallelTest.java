package nitin.multithreading.parallelStreams;

import com.entity.Cancer;
import com.google.common.collect.Lists;
import com.utilities.CsvReadUtility;
import com.utilities.MultiThreadUtility;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ParallelTest {

    public static final int BATCH_SIZE = 500;

    public static void main(String[] args) {
        updates();
    }
    private static void updates() {
        System.out.println("Gathering DB Data from ORDER_ACTION_SIGNATURE");

        List<Cancer> existingHhdRecords = CsvReadUtility.getCancerData();
        List<List<Cancer>> partition = Lists.partition(existingHhdRecords, BATCH_SIZE);

        System.out.println("total partitions " + partition.size());
        try {
            partition.parallelStream()
                .forEach(cancerPartitionList -> {
                    List<Object> objectList = new ArrayList<>();
                    //cancerPartitionList.parallelStream().forEach(singleHhdOrder -> { no fork join here
                    cancerPartitionList.forEach(singleHhdOrder -> {
                        singleHhdOrder.setRace(null);//Changing int to double
                        singleHhdOrder.setCancer_sites("test");
                        objectList.add(singleHhdOrder);
                    });

                if(null != objectList ){
                    System.out.println("updating # of records " + objectList.size());
                    //Simulating DB Write
                    MultiThreadUtility.delay(1000);
                }
            });
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
}