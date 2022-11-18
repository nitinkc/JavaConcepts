package nitin.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class JacksonMapperTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        //Serializing Object
        TestSerial testSerial = TestSerial.builder()
                .name("Katie")//The transient variable does not participate in the serialization process. It takes defalut values
                .age(5)
                .password("TESTING")
                .someChar('%')
                .finalTransientString("Final Transient String showing")//Testing final transient. Final overpowers and thus there is no effect of transient
                .build();


        mapper.writeValue(new File("src/main/java/nitin/serialization/serialObjectTransient.txt"), TestSerial.class);

        TestSerial c = mapper.readValue(new File("src/main/java/nitin/serialization/serialObjectTransient.txt"), TestSerial.class);
        System.out.println("*********************** After Deserialization ****************************");
        System.out.println(c);
    }
}
