package nitin.multithreading.asynchronousProgramming.completableFutureBasics;

import com.entity.CovidIndia;
import com.entity.dto.CovidIndiaTransformed;
import nitin.multithreading.asynchronousProgramming.completableFutureBasics.functions.DataTransformationFunctions;
import nitin.multithreading.asynchronousProgramming.completableFutureBasics.service.DataFetchService;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.utilities.PerformanceUtility.startTimer;
import static com.utilities.PerformanceUtility.stopTimer;

public class A3CompletableFutureDataService {
    public static void main(String[] args) {

        DataFetchService dataFetchService = new DataFetchService();

        startTimer();
        CompletableFuture<List<CovidIndiaTransformed>> listCompletableFuture =
                CompletableFuture.supplyAsync(() -> dataFetchService.fetchCovidIndiaData())//returns the completable future of type entity
                        .thenApply(covidIndiaList -> getIndiaTransformedList(covidIndiaList));//Applying function to each element of list
        stopTimer();//If join is not used, the operation continues and program reaches here, without actually download the data

        //Get the data out of the future
        List<CovidIndiaTransformed> extractedList = listCompletableFuture.join();
        extractedList
                .stream()
                .limit(10)
                .forEach(x -> System.out.println(x.getDeaths() + " : " + x.getDate()));
        System.out.println("Completed!!");
    }

    private static List<CovidIndiaTransformed> getIndiaTransformedList(List<CovidIndia> covidIndiaList) {
        //Get the Raw list and transform
        List<CovidIndiaTransformed> collect = covidIndiaList
                .stream()
                .map(DataTransformationFunctions.covidFunction)
                .collect(Collectors.toList());

        //Return sorted list
        return collect.stream()
                .sorted(Comparator.comparing(CovidIndiaTransformed::getDeaths)
                        .reversed()
                        .thenComparing(CovidIndiaTransformed::getCityAndState))
                .collect(Collectors.toList());
    }
}
