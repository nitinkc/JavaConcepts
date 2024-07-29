package nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.functions;

import com.entity.Vehicle;
import com.entity.dto.VehicleTransformed;

import java.time.ZonedDateTime;
import java.util.function.Function;

public class DataTransformationFunctions {

    public static Function<Vehicle, VehicleTransformed> vehicleFunction =
            (vehicle) -> {

                StringBuilder carOptionsBuilder = new StringBuilder();
                StringBuilder specsBuilder = new StringBuilder();

                for (int i = 0; i < vehicle.getCarOptions().size() - 1; i++) {
                    carOptionsBuilder.append(vehicle.getCarOptions().get(i)).append(";");
                }
                carOptionsBuilder.append(vehicle.getCarOptions().get(vehicle.getCarOptions().size() - 1));//Off by one

                for (int i = 0; i < vehicle.getSpecs().size() - 1; i++) {
                    specsBuilder.append(vehicle.getSpecs().get(i)).append(";");
                }
                specsBuilder.append(vehicle.getSpecs().get(vehicle.getSpecs().size() - 1));//Off by one

                return VehicleTransformed.builder()
                        .carOptions(carOptionsBuilder.toString())
                        .specs(specsBuilder.toString())
                        //Other properties
                        .carType(vehicle.getCarType())
                        .color(vehicle.getColor())
                        .doors(vehicle.getDoors())
                        .driveType(vehicle.getDriveType())
                        .fuelType(vehicle.getFuelType())
                        .id(vehicle.getId())
                        .kilometrage(vehicle.getKilometrage())
                        .licensePlate(vehicle.getLicensePlate())
                        .makeAndModel(vehicle.getMakeAndModel())
                        .mileage(vehicle.getMileage())
                        .transmission(vehicle.getTransmission())
                        .uid(vehicle.getUid())
                        .vin(vehicle.getVin())
                        .build();
            };
}
