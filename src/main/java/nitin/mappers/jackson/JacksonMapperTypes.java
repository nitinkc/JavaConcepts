package nitin.mappers.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import nitin.mappers.jackson.model.RandomVehicle;

public class JacksonMapperTypes {
    private static final String VEHICLE_URL =
            "https://random-data-api.com/api/vehicle/random_vehicle?size=";
    ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        // List<RandomVehicle> randomVehicles = getFewRandomVehicles(10);
        // System.out.println(randomVehicles.size());
        // System.out.println(randomVehicles.get(0).toString());

        RandomVehicle randomVehicle = getSingleJsonFromFile();
    }

    public static List<RandomVehicle> getFewRandomVehicles(int size) {
        ObjectMapper mapper = new ObjectMapper();
        List<RandomVehicle> randomVehicleList = new ArrayList<>();

        try {
            randomVehicleList =
                    mapper.readValue(
                            new URL(VEHICLE_URL + size),
                            new TypeReference<List<RandomVehicle>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomVehicleList;
    }

    private static RandomVehicle getSingleJsonFromFile() throws IOException {
        URL resource = new URL("file:src/test/resources/json/single_random_vehicle.json");
        ObjectMapper mapper = new ObjectMapper();

        RandomVehicle vehicle = mapper.readValue(resource, RandomVehicle.class);
        String convertedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vehicle);

        System.out.println(convertedJson);
        return vehicle;
    }
}
