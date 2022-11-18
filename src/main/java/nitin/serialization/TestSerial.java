package nitin.serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder
@AllArgsConstructor
@JsonIgnoreProperties
public class TestSerial implements Serializable {
    private String name;
    private transient int age;
    private transient String password;
    private transient char someChar;
    private final transient String finalTransientString;
    //Testing for the Static variable. Static variables are NOT The part of Object,
    //The are the part of Class
    private static int staticInt = 342324;
    //Similarly there is no effect of static transient
    private static transient String staticTransientString = "Static Transient String showing";;
}
