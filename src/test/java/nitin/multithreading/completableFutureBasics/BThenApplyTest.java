package nitin.multithreading.completableFutureBasics;

import com.entity.dto.VehicleTransformed;
import nitin.multithreading.asynchronousProgramming.A4ThenApply;
import nitin.multithreading.asynchronousProgramming.completableFutureBasics.service.DataFetchService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class BThenApplyTest {

    @Mock
    DataFetchService dfs = new DataFetchService();

    @InjectMocks
    A4ThenApply cf;//= new BThenApply(dfs);

    //@Test
    public void vehicleCompletableFutureTest() {
        //given

        //when
        CompletableFuture<List<VehicleTransformed>> completableFuture = A4ThenApply.vehicleCompletableFuture();

        List<VehicleTransformed> vehicleTransformedList = completableFuture.join();

        //then
        assertEquals(vehicleTransformedList.size(), 100);
        /*completableFuture
                .thenAccept(list -> {
                    assertEquals(list.size(),100);
                })
                .join();*/
    }

    //@Test
    public void vehicleCompletableFutureTest2() {
        //given

        //when
        CompletableFuture<List<VehicleTransformed>> completableFuture = A4ThenApply.vehicleCompletableFuture();

        //then
        List<VehicleTransformed> vehicleTransformedList = completableFuture.join();

        assertTrue(vehicleTransformedList.get(0).getCarOptions().contains(";"));
        /*completableFuture
                .thenAccept(list -> {
                    assertTrue(list.get(0).getCarOptions().contains(";"));
                })
                .join();*/
    }
}