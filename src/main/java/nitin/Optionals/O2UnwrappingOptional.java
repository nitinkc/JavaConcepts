package nitin.Optionals;

import java.util.Optional;

/**
 * Created by nichaurasia on Friday, May/29/2020 at 4:31 PM
 */

public class O2UnwrappingOptional {
    public static void main(String[] args) {

        //simple Way
        //BigInteger bigInteger = MathUtils.factorial(58);
        //System.out.println(bigInteger);+

        String str = "Test String";
        String emptyString = null;

        //Optional way
        Optional<String> strOptional = Optional.of(str);
        Optional<String> emptyStringOptional = Optional.empty();
        // get() method
        System.out.println("1: " + strOptional.get());

        // isPresent Check
        String ret = strOptional.isPresent() ? strOptional.get() : "val not present";
        String retEmpty = emptyStringOptional.isPresent() ? emptyStringOptional.get() : "Alternative Value";
        System.out.println("2: " + ret);
        System.out.println("3: " + retEmpty);

        // orElse, orElseGet -> Provides an alternative in case of a null return.
        String ret2 = emptyStringOptional.orElse("tasty treat");
        System.out.println(ret2);

        //OrElseGet needs a supplier
        String ret3 = emptyStringOptional.orElseGet(() -> "OrElseGet Testing");

        //OrElseThrow
        String ret4 = emptyStringOptional.orElseThrow();//No such element exception
    }
}
