package nitin.multithreading.completableFutureBasics.service;

import com.entity.CovidIndia;
import com.entity.Vehicle;
import com.utilities.JsonReadUtility;

import java.util.List;

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
}
