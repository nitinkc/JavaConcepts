package nitin.multithreading.completableFutureBasics.service;

import com.entity.CovidIndia;
import com.entity.Vehicle;
import com.entity.VehicleTransformed;
import com.utilities.JsonReadUtility;

import java.sql.Struct;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.utilities.MultiThreadUtility.delay;
import static com.utilities.MultiThreadUtility.logMessage;

public class DataFetchService {

    public List<CovidIndia> fetchCovidIndiaData(){
        return JsonReadUtility.covidReader();
    }

    public List<Vehicle> fetchVehicles(){
        return JsonReadUtility.getRandomVehicles();
    }

    public String firstNameService(){
        delay(1000);
        logMessage("From firstNameService");
        return "john";
    }

    public String lastNameService(){
        delay(1000);
        logMessage("From lastNameService");
        return "doe";
    }

    public CompletableFuture<String> findVehicleWithGreatMileage(List<VehicleTransformed> vehicleList){
        logMessage("From composeVehicleData");
        //Returning the vehicle with maximum mileage
        return CompletableFuture.supplyAsync(() -> vehicleList.stream()
                .sorted(Comparator.comparing(VehicleTransformed::getMileage).reversed())
                .findFirst().get().getMileage().toString());
    }

    public CompletableFuture<String> futureName(String name){
        return CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return ("Hello " + name );
        });
    }
}
