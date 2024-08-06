package nitin.multithreading;

import lombok.NoArgsConstructor;
import java.math.BigInteger;

@NoArgsConstructor
public class Factorial {

    public BigInteger compute(long inputNumber) {
        return factorial(inputNumber);
    }

    private BigInteger factorial(long n) {
        BigInteger result = BigInteger.ONE;

        for (long i = n; i > 0; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
