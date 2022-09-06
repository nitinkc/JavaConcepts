package nitin.multithreading.completableFutureBasics;

import com.entity.dto.VehicleTransformed;
import nitin.multithreading.completableFutureBasics.service.DataFetchService;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BThenApplyTest {

    DataFetchService dfs = new DataFetchService();
    BThenApply cf = new BThenApply(dfs);

    @Test
    public void vehicleCompletableFutureTest() {
        //given

        //when
        CompletableFuture<List<VehicleTransformed>> completableFuture = cf.vehicleCompletableFuture();

        //then
        completableFuture
                .thenAccept(list -> {
                    assertEquals(list.size(),100);
                })
                .join();
    }

    @Test
    public void vehicleCompletableFutureTest2() {
        //given

        //when
        CompletableFuture<List<VehicleTransformed>> completableFuture = cf.vehicleCompletableFuture();

        //then
        completableFuture
                .thenAccept(list -> {
                    assertTrue(list.get(0).getCarOptions().contains(";"));
                })
                .join();
    }
}