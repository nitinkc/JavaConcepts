package nitin.multithreading.completableFutureBasics;

import com.entity.VehicleTransformed;
import com.utilities.MultiThreadUtility;
import nitin.multithreading.completableFutureBasics.functions.DataTransformationFunctions;
import nitin.multithreading.completableFutureBasics.service.DataFetchService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static com.utilities.MultiThreadUtility.delay;

public class DThenCompose {
    DataFetchService dataFetchService;

    public DThenCompose(DataFetchService dataFetchService){
        this.dataFetchService =  dataFetchService;
    }

    private List<VehicleTransformed> vehicleCompletableFuture() {
        CompletableFuture<List<VehicleTransformed>> x = CompletableFuture
                .supplyAsync(() -> dataFetchService.fetchVehicles())
                //.thenApply(vehicleList -> vehicleList.stream().map(DataTransformationFunctions.vehicleFunction));
                .thenApply(vehicleList -> vehicleList.stream().map(vehicle -> DataTransformationFunctions.vehicleFunction.apply(vehicle)).collect(Collectors.toList()));

        return x.join();
    }


    public CompletableFuture<String> getHeighestMileageCar() {

        return CompletableFuture.supplyAsync(this::vehicleCompletableFuture)
                .thenCompose((previousVehicleFuture) ->
                        dataFetchService.findVehicleWithGreatMileage(previousVehicleFuture));
    }

    public CompletableFuture<String> getGreetings_compose(){

        //Fetch the name from the first name serviceTask and then feed the output to the futureName service for greeting
        return CompletableFuture.supplyAsync(dataFetchService::firstNameService)
                .thenCompose((firstNameFromPrevious) -> dataFetchService.futureName(firstNameFromPrevious));
    }
}