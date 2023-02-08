package nitin.asynchronousProgramming;

import com.entity.Beer;
import com.entity.Vehicle;
import com.utilities.InternetUtilities;
import com.utilities.RestGETReadUtility;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A14AllOfHeterogenious {
    public static void main(String[] args) {
        InternetUtilities internetUtilities = new InternetUtilities();

        CompletableFuture<List<Beer>> beerCompletableFuture =
                CompletableFuture.supplyAsync(() -> internetUtilities.getBeers(1));
        CompletableFuture<List<Vehicle>> vehicleCompletableFuture =
                CompletableFuture.supplyAsync(() -> RestGETReadUtility.getRandomVehicles(1));

        List<CompletableFuture> completableFutures = Arrays.asList(beerCompletableFuture, vehicleCompletableFuture);

        CompletableFuture<Void> resultantCf = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]));

        CompletableFuture<List> allFutureResults = resultantCf
                .thenApply(t -> completableFutures
                        .stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        try {
            System.out.println("Result - " + allFutureResults.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static String getString(CompletableFuture<List<Beer>> beerCompletableFuture, CompletableFuture<List<Vehicle>> vehicleCompletableFuture) {
        String beer = beerCompletableFuture
                .join().stream().findFirst().get().getAlcohol();

        vehicleCompletableFuture.join()
                .get(0);

        /*StringBuilder builder = new StringBuilder();
        String ret = builder
                .append(beer.getBrand())
                .append(vehicle.getMakeAndModel())
                .toString();*/

        return "";
    }
}
