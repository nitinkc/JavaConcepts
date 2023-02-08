package nitin.asynchronousProgramming.completableFutureBasics.service;

import com.entity.CovidIndia;
import com.entity.Vehicle;
import com.entity.dto.VehicleTransformed;
import com.utilities.RestGETReadUtility;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.*;

public class DataFetchService {

    public List<CovidIndia> fetchCovidIndiaData(){
        return RestGETReadUtility.covidReader();
    }

    public List<Vehicle> fetchVehicles(int size){
        return RestGETReadUtility.getRandomVehicles(size);
    }

    public String firstNameService(int delayInMillisec){
        delay(delayInMillisec);//simulating task completion latency
        logMessage("From firstNameService");
        return "john";
    }

    public String lastNameService(int delayInMillisec){
        delay(delayInMillisec);
        logMessage("From lastNameService");
        return "doe";
    }

    public String greetingsService(int delayInMillisec){
        delay(delayInMillisec);
        logMessage("From Hello!!");
        return "Hello!";
    }

    public CompletableFuture<VehicleTransformed> findVehicleWithGreatMileage(List<VehicleTransformed> vehicleList){
        logMessage("From composeVehicleData");
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
