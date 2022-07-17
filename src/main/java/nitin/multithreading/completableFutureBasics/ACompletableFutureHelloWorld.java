package nitin.multithreading.completableFutureBasics;

import com.entity.CovidIndia;
import com.entity.CovidIndiaTransformed;
import nitin.multithreading.completableFutureBasics.service.DataFetchService;

import java.time.ZonedDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.utilities.PerformanceUtility.startTimer;
import static com.utilities.PerformanceUtility.stopTimer;

public class ACompletableFutureHelloWorld {
    public static void main(String[] args) {

        DataFetchService dataFetchService = new DataFetchService();
        Function<CovidIndia, CovidIndiaTransformed> function =
                (covidIndia) -> {
                    CovidIndiaTransformed covidIndiaTransformed = new CovidIndiaTransformed();

                    //Transformed
                    covidIndiaTransformed.setDate(ZonedDateTime.parse(covidIndia.getDate()));
                    covidIndiaTransformed.setCityAndState(new StringBuilder()
                            .append(covidIndia.getCity())
                            .append(", ")
                            .append(covidIndia.getProvince())
                            .toString());

                    //As it is
                    covidIndiaTransformed.setActive(covidIndia.getActive());
                    covidIndiaTransformed.setDeaths(covidIndia.getDeaths());
                    covidIndiaTransformed.setConfirmed(covidIndia.getConfirmed());

                    return covidIndiaTransformed;
        };

        startTimer();
        CompletableFuture.supplyAsync(() -> dataFetchService.fetchCovidIndiaData())//returns the completable future of type entity
                //.thenApply(covidIndiaList -> covidIndiaList.stream().sorted(Comparator.comparing(CovidIndia::getDeaths).reversed().thenComparing(CovidIndia::getActive)).collect(Collectors.toList())) //Applying function to each element of list
                .thenApply(covidIndiaList -> covidIndiaList.stream().map(function).collect(Collectors.toList()))
                .thenAccept((covidIndiaTransformedList) -> {
                    covidIndiaTransformedList.forEach(x -> System.out.println(x.getDate()));
                })
               .join()//waiting operation
            ;
        stopTimer();//If join is not used, the operation continues and program reaches here, without actually download the data
        System.out.println("Completed!!");

    }
}
