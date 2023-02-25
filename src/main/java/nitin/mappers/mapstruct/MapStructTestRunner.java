package nitin.mappers.mapstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import nitin.mappers.mapstruct.dto.TesterDto;
import nitin.mappers.mapstruct.mapper.TestMapper;
import nitin.mappers.mapstruct.model.Tester;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.net.URL;

public class MapStructTestRunner {
    public static void main(String[] args) throws IOException {
        final TestMapper mapper = Mappers.getMapper(TestMapper.class);

        URL resource = new URL("file:src/main/resources/json/object-mapper-tester.json");
        ObjectMapper om = new ObjectMapper();

        Tester tester = getTestData(resource, om);
        System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(tester));

        TesterDto testerDto = mapper.testMapper(tester);
        System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(testerDto));
/*
        Map<String, String> map = om.readValue(resource, new TypeReference<Map<String, String>>() {});
        TesterDto testerDto2 = mapper.testMapperFromMap(map);
        System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(testerDto2));

 */

    }

    private static Tester getTestData(URL resource, ObjectMapper om)  {
        Tester tester = new Tester();
        try {
            tester = om.readValue(resource, Tester.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tester;
    }
}
