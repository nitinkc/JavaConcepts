package nitin.optionals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.*;

public class OptionalOrElse {
    public static void main(String[] args) {
        List<String> medList = Arrays.asList(null, "aMed", "bMed");
        List<String> labList = Arrays.asList(null, null, null, null);
        Patient patient = new Patient();

        /**
         * Potential Side Effects:
         *
         * <p>If patient is accessed or modified from different parts of your program concurrently,
         * changes made to it in one place can affect its state in another place. This can lead to
         * inconsistencies or unexpected behaviors.
         */

        // Process labTests to get a single valid result or an empty list
        labList.parallelStream()
                .filter(data -> null != data)
                .findFirst()
                .ifPresentOrElse( // Shared Mutability
                        value -> patient.setLabTests(Collections.singletonList(value)),
                        () -> patient.setLabTests(Collections.emptyList()));

        // Process medTests to get a single valid result or an empty list
        List<String> singleMed =
                medList.stream()
                        .filter(data -> data != null)
                        .findFirst()
                        .map(Collections::singletonList)
                        .orElse(Collections.emptyList());

        patient.setMedTests(singleMed); // Avoiding Shared Mutability

        System.out.println(patient);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
class Patient {
    List<String> labTests;
    List<String> medTests;
}
