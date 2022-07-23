package nitin.multithreading.completableFutureBasics;

import nitin.multithreading.completableFutureBasics.functions.DataTransformationFunctions;
import nitin.multithreading.completableFutureBasics.service.DataFetchService;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.utilities.PerformanceUtility.startTimer;
import static com.utilities.PerformanceUtility.stopTimer;

public class ACompletableFutureHelloWorld {
    public static void main(String[] args) {

        DataFetchService dataFetchService = new DataFetchService();

        startTimer();
        CompletableFuture.supplyAsync(() -> dataFetchService.fetchCovidIndiaData())//returns the completable future of type entity
                //.thenApply(covidIndiaList -> covidIndiaList.stream().sorted(Comparator.comparing(CovidIndia::getDeaths).reversed().thenComparing(CovidIndia::getActive)).collect(Collectors.toList())) //Applying function to each element of list
                .thenApply(covidIndiaList -> covidIndiaList.stream().map(DataTransformationFunctions.covidFunction).collect(Collectors.toList()))
                .thenAccept((covidIndiaTransformedList) -> {
                    covidIndiaTransformedList.forEach(x -> System.out.println(x.getDate()));
                })
               .join()//waiting operation
            ;
        stopTimer();//If join is not used, the operation continues and program reaches here, without actually download the data
        System.out.println("Completed!!");
    }
}
