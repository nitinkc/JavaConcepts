package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service;

import com.entity.Vehicle;
import com.entity.dto.VehicleTransformed;
import com.utilities.RestGETReadUtility;

import static nitin.multithreading.cVirtualThreads.v3structuredConcurrency.BlockingIOTasks.TaskResponse;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static com.utilities.MultiThreadUtility.*;

public class DataFetchService {

    public List<Vehicle> fetchVehicles(int size) {
        return RestGETReadUtility.getRandomVehicles(size);
    }

    public String firstNameService(int delayInMillisec) {
        delay(delayInMillisec);//simulating task completion latency
        logMessage("From firstNameService");
        return "john";
    }

    public String lastNameService(int delayInMillisec) {
        delay(delayInMillisec);
        logMessage("From lastNameService");
        return "doe";
    }

    public String greetingsService(int delayInMillisec) {
        delay(delayInMillisec);
        logMessage("From Hello!!");
        return "Hello!";
    }

    public CompletableFuture<VehicleTransformed> findVehicleWithGreatMileage(List<VehicleTransformed> vehicleList) {
        logMessage("From composeVehicleData");
        //Returning the vehicle with maximum mileage
        return CompletableFuture.supplyAsync(() -> vehicleList.stream()
                .sorted(Comparator.comparing(VehicleTransformed::getMileage).reversed())
                .findFirst().get());
    }

    public CompletableFuture<String> futureName(String name) {
        return CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return ("Hello " + name);
        });
    }

    public TaskResponse microTask(String name, int secs, boolean isSuccess) {
        logShortMessage("Begin microTask of " + secs + " seconds");

        //Fail Fast
        if (!isSuccess || secs > 7) {
            throw new RuntimeException(STR."Task Failed : \{name} \{isSuccess} \{secs}");
        }

        long currentTime = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(secs);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       long endTime =  System.currentTimeMillis();

        logShortMessage("End microTask of " + secs + " seconds");
        return new TaskResponse(name, String.valueOf(secs), endTime - currentTime);
    }
}
