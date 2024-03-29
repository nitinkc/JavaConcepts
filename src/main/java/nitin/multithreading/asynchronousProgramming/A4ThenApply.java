package nitin.multithreading.asynchronousProgramming;

import com.entity.Vehicle;
import com.entity.dto.VehicleTransformed;
import nitin.multithreading.asynchronousProgramming.completableFutureBasics.functions.DataTransformationFunctions;
import nitin.multithreading.asynchronousProgramming.completableFutureBasics.service.DataFetchService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class A4ThenApply {
    static DataFetchService dataFetchService;

    /**
     * ### thenApply()
     * Completion Stage method
     * used for applying transformations, takes a Function
     * thenApply deals with **Function that returns** a value
     * returns CompletableFuture of TypeT
     */

    public static void main(String[] args) {
        dataFetchService = new DataFetchService();
        CompletableFuture<List<VehicleTransformed>> completableFuture = vehicleCompletableFuture();

        List<VehicleTransformed> join = completableFuture.join();
        System.out.println(join.size());
    }

    public static CompletableFuture<List<VehicleTransformed>> vehicleCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> dataFetchService.fetchVehicles(2))
                .thenApply(vehicles -> getTransformedList(vehicles));//returns the completable future of type entity
    }

    private static List<VehicleTransformed> getTransformedList(List<Vehicle> vehicles) {
        return vehicles
                .stream()
                .map(DataTransformationFunctions.vehicleFunction)
                .collect(Collectors.toList());
    }
}
