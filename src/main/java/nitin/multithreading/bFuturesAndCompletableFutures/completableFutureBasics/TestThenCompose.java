package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import com.entity.dto.VehicleTransformed;
import java.util.concurrent.CompletableFuture;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;

public class TestThenCompose {
    public static DataFetchService dfs = new DataFetchService();
    public static A12ThenCompose cf = new A12ThenCompose(dfs);

    public static void main(String[] args) {
        CompletableFuture<String> testGetGreetings_compose =
                A12ThenCompose
                        .getGreetings_compose(); // Get name from one service and pass the name into
        // another

        CompletableFuture<VehicleTransformed> testGetHeighestMileageCar =
                A12ThenCompose
                        .getHeighestMileageCar(); // Get name from one service and pass the name
        // into another

        // Gather the results adn then accept
        testGetGreetings_compose
                .thenAccept(
                        result -> {
                            System.out.println(result);
                        })
                .join();

        testGetHeighestMileageCar
                .thenAccept(
                        result -> {
                            System.out.println(result);
                        })
                .join();
    }
}
