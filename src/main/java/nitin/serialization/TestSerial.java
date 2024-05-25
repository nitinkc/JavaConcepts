package nitin.serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
@AllArgsConstructor
@JsonIgnoreProperties
public class TestSerial implements Serializable {
    //Testing for the Static variable. Static variables are NOT The part of Object,
    //The are the part of Class
    private static int staticInt = 342324;
    //Similarly there is no effect of static transient
    private static String staticTransientString = "Static Transient String showing";
    private final transient String finalTransientString;
    private String name;
    private transient int age;
    private transient String password;
    private transient char someChar;
}
