package nitin.multithreading.completableFutureBasics;

import com.entity.dto.VehicleTransformed;
import com.utilities.PerformanceUtility;
import java.util.concurrent.CompletableFuture;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.A12ThenCompose;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DThenComposeTest {

    DataFetchService dfs = new DataFetchService();
    A12ThenCompose cf = new A12ThenCompose(dfs);

    @Test
    public void futureNameTest() {

        PerformanceUtility.startTimer();
        // when
        CompletableFuture<String> test =
                A12ThenCompose
                        .getGreetings_compose(); // Get name from one service and pass the name into
        // another

        // then
        test.thenAccept(
                        result -> {
                            Assert.assertEquals(result, "Hello john");
                        })
                .join();
        PerformanceUtility.stopTimer(); // Takes time = task1 + task2
    }

    @Test
    public void vehicleComposeTest() {

        PerformanceUtility.startTimer();
        // when
        CompletableFuture<VehicleTransformed> test =
                A12ThenCompose
                        .getHeighestMileageCar(); // Get name from one service and pass the name
        // into another

        // then
        test.thenAccept(
                        result -> {
                            // System.out.println(result);
                            Assert.assertNotNull(result);
                        })
                .join();
        PerformanceUtility.stopTimer();
    }
}
