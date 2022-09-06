package nitin.multithreading.completableFutureBasics;

import com.entity.dto.VehicleTransformed;
import nitin.multithreading.completableFutureBasics.functions.DataTransformationFunctions;
import nitin.multithreading.completableFutureBasics.service.DataFetchService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class BThenApply {

    DataFetchService dataFetchService;

    public BThenApply(DataFetchService dataFetchService){
        this.dataFetchService =  dataFetchService;
    }

    /**
     * ### thenApply()
     *     * Completion Stage method
     *     * used for applying transformations, takes a Function
     *     * thenApply deals with **Function that returns** a value
     *     * returns CompletableFuture<T>() of TypeT
     * @return
     */
    public CompletableFuture<List<VehicleTransformed>> vehicleCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> dataFetchService.fetchVehicles())
                .thenApply(vehicles -> vehicles.stream().map(DataTransformationFunctions.vehicleFunction).collect(Collectors.toList()));//returns the completable future of type entity
    }
}
