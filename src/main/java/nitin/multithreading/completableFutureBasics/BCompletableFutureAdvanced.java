package nitin.multithreading.completableFutureBasics;

import com.entity.Vehicle;
import com.entity.VehicleTransformed;
import nitin.multithreading.completableFutureBasics.functions.DataTransformationFunctions;
import nitin.multithreading.completableFutureBasics.service.DataFetchService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BCompletableFutureAdvanced {

    DataFetchService dataFetchService;

    public BCompletableFutureAdvanced(DataFetchService dataFetchService){
        this.dataFetchService =  dataFetchService;
    }


    public CompletableFuture<List<VehicleTransformed>> vehicleCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> dataFetchService.fetchVehicles())
                .thenApply(vehicles -> vehicles.stream().map(DataTransformationFunctions.vehicleFunction).collect(Collectors.toList()));//returns the completable future of type entity
    }
}
