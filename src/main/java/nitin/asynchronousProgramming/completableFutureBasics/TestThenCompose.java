package nitin.asynchronousProgramming.completableFutureBasics;

import com.entity.dto.VehicleTransformed;
import nitin.asynchronousProgramming.A12ThenCompose;
import nitin.asynchronousProgramming.completableFutureBasics.service.DataFetchService;

import java.util.concurrent.CompletableFuture;

public class TestThenCompose {
    public static DataFetchService dfs = new DataFetchService();
    public static A12ThenCompose cf = new A12ThenCompose(dfs);

    public static void main(String[] args) {
        CompletableFuture<String> testGetGreetings_compose = cf.getGreetings_compose();//Get name from one service and pass the name into another

        CompletableFuture<VehicleTransformed> testGetHeighestMileageCar = cf.getHeighestMileageCar();//Get name from one service and pass the name into another

        //Gather the results adn then accept
        testGetGreetings_compose.thenAccept(result -> {
            System.out.println(result);
        }).join();

        testGetHeighestMileageCar.thenAccept(result -> {
            System.out.println(result);
        }).join();
    }
}