package nitin.optionals;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class NullabilityTest {
    public static void main(String[] args) {

        String str = null;
        // Create an Optional that may or may not have a value
        Optional<String> optional = Optional.ofNullable(str); // Value expecting a String

        System.out.println(optional.get()); // NoSuchElementException: No value present
        System.out.println(optional.orElse("other")); // other
        System.out.println(optional.orElseGet(String::new)); // EMPTY String
        System.out.println(optional.isPresent()); // false

        AtomicReference<String> name = new AtomicReference<>(new String());
        optional.ifPresentOrElse(
                value -> name.set(value.toUpperCase()), () -> new NullPointerException());
    }
}
