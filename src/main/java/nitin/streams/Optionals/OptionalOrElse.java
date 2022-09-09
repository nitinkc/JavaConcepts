package nitin.streams.Optionals;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class OptionalOrElse {
    public static void main(String[] args) {
        Patient patient = Patient.builder()
                .medTests(Arrays.asList(null,"aMed","bMed"))
                .labTests(Arrays.asList(null,null,null,null))
                .build();

        Patient patient2 = Patient.builder()
                .medTests(null)
                .labTests(null)
                .build();

        System.out.println(patient2.getLabTests().size());

       /* if (null != (patient.getLabTests())) {
            patient.getLabTests()
                    .stream()
                    .filter(data -> null != data)
                    .findFirst()
                    .ifPresentOrElse(
                            value -> patient.setLabTests(Collections.singletonList(value)),
                            () -> patient.setLabTests(Collections.emptyList()));
        }*/

        List<String> singleLab = Optional.ofNullable(Collections.singletonList(
                    patient.getLabTests()
                    .stream()
                    .filter(data -> null != data)
                    .findFirst().orElse(StringUtils.EMPTY)))
                .orElse(Collections.emptyList());

        patient.setLabTests(singleLab);

        if (null != (patient.getMedTests())) {
            patient.getMedTests()
                    .stream()
                    .filter(data -> null != data)
                    .findFirst()
                    .ifPresentOrElse(
                            value -> patient.setMedTests(Collections.singletonList(value)),
                            () -> patient.setMedTests(Collections.emptyList()));
        } else {
            //TODO: Do we have to show the empty lab results even though DB returns null??
            patient.setMedTests(Collections.emptyList());
        }

        System.out.println(patient);
    }
}

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
class Patient{
    List<String> labTests;
    List<String> medTests;
}
