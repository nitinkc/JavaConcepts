package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import com.entity.Vehicle;
import com.entity.dto.VehicleTransformed;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.functions.DataTransformationFunctions;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;

public class A4ThenApply {
    static DataFetchService dataFetchService;

    /**
     * ### thenApply() Completion Stage method used for applying transformations, takes a Function
     * thenApply deals with **Function that returns** a value returns CompletableFuture of Type T
     */
    public static void main(String[] args) {
        dataFetchService = new DataFetchService();
        CompletableFuture<List<VehicleTransformed>> completableFuture =
                CompletableFuture.supplyAsync(() -> dataFetchService.fetchVehicles(2))
                        .thenApply(
                                vehicles ->
                                        getTransformedList(
                                                vehicles)); // returns the completable future of
        // type entity

        List<VehicleTransformed> join = completableFuture.join();
        System.out.println(join.size());
    }

    private static List<VehicleTransformed> getTransformedList(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(DataTransformationFunctions.vehicleFunction)
                .collect(Collectors.toList());
    }
}
