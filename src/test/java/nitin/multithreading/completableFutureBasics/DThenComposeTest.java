package nitin.multithreading.completableFutureBasics;


import com.entity.VehicleTransformed;
import com.utilities.PerformanceUtility;
import nitin.multithreading.completableFutureBasics.service.DataFetchService;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class DThenComposeTest {

    DataFetchService dfs = new DataFetchService();
    DThenCompose cf = new DThenCompose(dfs);

    @Test
    public void futureNameTest() {

        PerformanceUtility.startTimer();
        //when
        CompletableFuture<String> test = cf.getGreetings_compose();//Get name from one service and pass the name into another

        //then
        test.thenAccept(result -> {
            Assert.assertEquals(result, "Hello john");
        }).join();
        PerformanceUtility.stopTimer();//Takes time = task1 + task2
    }

    @Test
    public void vehicleComposeTest() {

        PerformanceUtility.startTimer();
        //when
        CompletableFuture<VehicleTransformed> test = cf.getHeighestMileageCar();//Get name from one service and pass the name into another

        //then
        test.thenAccept(result -> {
            //System.out.println(result);
            Assert.assertNotNull(result);
        }).join();
        PerformanceUtility.stopTimer();
    }
}