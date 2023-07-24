package nitin.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nitin.mappers.jackson.JacksonMapperTypes;
import nitin.mappers.jackson.model.RandomVehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MockitoExtension.class)
public class JacksonMapperTypesTest {

    @Mock
    private ObjectMapper objectMapper;

    @Test
    void getFewRandomVehicles() throws JsonProcessingException {
        RandomVehicle randomVehicle = RandomVehicle.builder()
                .id(6534)
                .uid("742b4374-032e-49bb-9b5b-92ffb457d313")
                .vin("NPWPCPYJP9H242398")
                .makeAndModel("Chevy Silverado")
                .transmission("CVT")
                .color("Yellow")
                .driveType("AWD")
                .fuelType("Gasoline Hybrid")
                .carType("Wagon")
                .carOptions(List.of("AM/FM Stereo",
                        "Airbag: Side",
                        "Airbag: Driver",
                        "CD (Multi Disc)",
                        "Cassette Player",
                        "Alloy Wheels"))
                .specs(List.of("Traveler/mini trip computer",
                        "Rear door child safety locks",
                        "20\" x 9.0\" front & 20\" x 10.0\" rear aluminum wheels",
                        "Electronic brakeforce distribution (EBD) w/brake assist (BA) -inc: Smart stop technology",
                        "Eco drive indicator",
                        "Leather-wrapped shift knob",
                        "Foldable front door storage pockets",
                        "Foldable front door storage pockets",
                        "Anti-lock brake system (ABS) -inc: electronic brake force distribution (EBD), brake assist"))
                .doors(2)
                .mileage(82508)
                .kilometer_range(45776)
                .licensePlate("SQT-5871")
                .build();

        List<RandomVehicle> randomVehicles = List.of(randomVehicle);
        //Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.eq(RandomVehicle.class))).thenReturn(randomVehicles);
        assertTrue(JacksonMapperTypes.getFewRandomVehicles(1).size() == 1);
        // Mockito.verify(objectMapper, Mockito.times(1)).readValue(Mockito.anyString(), Mockito.eq(RandomVehicle.class));
    }

    @Test
    void test_single_json_object() throws MalformedURLException, JsonProcessingException {
        String JSON_OBJECT = "{\n" +
                "\"id\": 6534,\n" +
                "\"uid\": \"742b4374-032e-49bb-9b5b-92ffb457d313\",\n" +
                "\"vin\": \"NPWPCPYJP9H242398\",\n" +
                "\"make_and_model\": \"Chevy Silverado\",\n" +
                "\"color\": \"Yellow\",\n" +
                "\"transmission\": \"CVT\",\n" +
                "\"drive_type\": \"AWD\",\n" +
                "\"fuel_type\": \"Gasoline Hybrid\",\n" +
                "\"car_type\": \"Wagon\",\n" +
                "\"car_options\": [\n" +
                "\"AM/FM Stereo\",\n" +
                "\"Airbag: Side\",\n" +
                "\"Airbag: Driver\",\n" +
                "\"CD (Multi Disc)\",\n" +
                "\"Cassette Player\",\n" +
                "\"Alloy Wheels\"\n" +
                "],\n" +
                "\"specs\": [\n" +
                "\"Traveler/mini trip computer\",\n" +
                "\"Rear door child safety locks\",\n" +
                "\"20\\\" x 9.0\\\" front & 20\\\" x 10.0\\\" rear aluminum wheels\",\n" +
                "\"Electronic brakeforce distribution (EBD) w/brake assist (BA) -inc: Smart stop technology\",\n" +
                "\"Eco drive indicator\",\n" +
                "\"Leather-wrapped shift knob\",\n" +
                "\"Foldable front door storage pockets\",\n" +
                "\"Foldable front door storage pockets\",\n" +
                "\"Anti-lock brake system (ABS) -inc: electronic brake force distribution (EBD), brake assist\"\n" +
                "],\n" +
                "\"doors\": 2,\n" +
                "\"mileage\": 82508,\n" +
                "\"kilometrage\": 45776,\n" +
                "\"license_plate\": \"SQT-5871\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        RandomVehicle vehicle = mapper.readValue(JSON_OBJECT, RandomVehicle.class);
        assertNotNull(vehicle);
        assertThat(vehicle.getColor(), containsString("Yellow"));
    }

    @Test
    void test_json_array() throws IOException {
        URL resource = new URL("file:src/test/resources/json/random_vehicle_array_json.json");

        ObjectMapper objectMapper = new ObjectMapper();
        List<RandomVehicle> randomVehicles = objectMapper.readValue(resource, new TypeReference<List<RandomVehicle>>() {
        });

        for (final RandomVehicle car : randomVehicles) {
            assertNotNull(car);
            if (car.getVin().equals("PDL2JHLPMMDJ97457"))
                assertThat(car.getMakeAndModel(), equalTo("BMW M3"));
        }
    }

    @Test
    void test_json_single_file() throws IOException {
        RandomVehicle vehicle = getSingleJsonFromFile();
        assertNotNull(vehicle);
        //assertThat(vehicle.getColor(), null);//containsString("Red"));
        assertEquals(vehicle.getCarOptions().size(),11);
      // assertNull(vehicle.getColor());
    }

    @Test
    void test_json_single_file_nulls() throws IOException {
        RandomVehicle vehicle = getSingleJsonFromFile();
        assertNotNull(vehicle);
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
