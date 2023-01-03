package nitin.streams.completableFutureBasics.service;

import com.entity.CovidIndia;
import com.entity.Vehicle;
import com.entity.dto.VehicleTransformed;
import com.utilities.RestGETReadUtility;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.delay;
import static com.utilities.MultiThreadUtility.logShortMessage;

public class DataFetchService {

    public List<CovidIndia> fetchCovidIndiaData(){
        return RestGETReadUtility.covidReader();
    }

    public List<Vehicle> fetchVehicles(){
        return RestGETReadUtility.getRandomVehicles();
    }

    public String firstNameService(){
        delay(1000);//simulating task completion latency
        logShortMessage("From firstNameService");
        return "john";
    }

    public String lastNameService(){
        delay(1000);
        logShortMessage("From lastNameService");
        return "doe";
    }

    public String greetingsService(){
        delay(1000);
        logShortMessage("From Hello!!");
        return "Hello!!";
    }

    public CompletableFuture<VehicleTransformed> findVehicleWithGreatMileage(List<VehicleTransformed> vehicleList){
        logShortMessage("From composeVehicleData");
        //Returning the vehicle with maximum mileage
        return CompletableFuture.supplyAsync(() -> vehicleList.stream()
                .sorted(Comparator.comparing(VehicleTransformed::getMileage).reversed())
                .findFirst().get());
    }

    public CompletableFuture<String> futureName(String name){
        return CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return ("Hello " + name );
        });
    }
}
