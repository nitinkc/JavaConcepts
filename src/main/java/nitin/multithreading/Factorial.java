package nitin.multithreading;

import java.math.BigInteger;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Factorial {

    public BigInteger compute(long inputNumber) {
        return factorial(inputNumber);
    }

    private BigInteger factorial(long n) {
        // logMessage("factorial running");
        BigInteger result = BigInteger.ONE;

        for (long i = n; i > 0; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
