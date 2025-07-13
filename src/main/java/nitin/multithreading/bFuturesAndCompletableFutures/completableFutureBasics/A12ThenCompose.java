package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics;

import com.entity.dto.VehicleTransformed;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.functions.DataTransformationFunctions;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;

@NoArgsConstructor
public class A12ThenCompose {
    static DataFetchService dataFetchService;

    public A12ThenCompose(DataFetchService dataFetchService) {
        A12ThenCompose.dataFetchService = dataFetchService;
    }

    // CHECK TEST CASES AS WELL

    /**
     * Completion Stage method Transform data from one form to another Input is Function functional
     * interface Deals with methods that return completableFuture
     *
     * @param args
     */
    public static void main(String[] args) {
        dataFetchService = new DataFetchService();

        CompletableFuture<String> greetingsComposeFuture = getGreetings_compose();
        greetingsComposeFuture.thenAccept(str -> System.out.println(str)).join();

        CompletableFuture<VehicleTransformed> vehicleTransformedCompletableFuture =
                getHeighestMileageCar();
        vehicleTransformedCompletableFuture
                .thenAccept(data -> System.out.println(data.toString()))
                .join();
    }

    public static CompletableFuture<VehicleTransformed> getHeighestMileageCar() {

        return CompletableFuture.supplyAsync(() -> vehicleCompletableFuture())
                .thenCompose(
                        (previousVehicleFuture) ->
                                dataFetchService.findVehicleWithGreatMileage(
                                        previousVehicleFuture));
    }

    public static CompletableFuture<String> getGreetings_compose() {

        // Fetch the name from the first name serviceTask and then feed the output to the futureName
        // service for greeting
        return CompletableFuture.supplyAsync(() -> dataFetchService.firstNameService(1000))
                .thenCompose(
                        (firstNameFromPrevious) ->
                                dataFetchService.futureName(firstNameFromPrevious));
    }

    private static List<VehicleTransformed> vehicleCompletableFuture() {
        CompletableFuture<List<VehicleTransformed>> x =
                CompletableFuture.supplyAsync(() -> dataFetchService.fetchVehicles(2))
                        .thenApply(
                                vehicleList ->
                                        vehicleList.stream()
                                                .map(
                                                        vehicle ->
                                                                DataTransformationFunctions
                                                                        .vehicleFunction
                                                                        .apply(vehicle))
                                                .collect(Collectors.toList()));

        return x.join();
    }
}
