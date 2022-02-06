package com.utilities;

import java.math.BigInteger;

/**
 * Created by nichaurasia on Friday, May/29/2020 at 4:45 PM
 */

public class MathUtils {

    public static BigInteger factorial(int i) {

        if (i < 0) {
            return BigInteger.valueOf(i);
        }

        if (i == 0) {
            return BigInteger.valueOf(1);
        }
        BigInteger ret = BigInteger.valueOf(1);
        long begin = System.currentTimeMillis();
        for (int x = i; i > 1; i--) {
            ret = BigInteger
                    .valueOf(x)
                    .multiply(ret);
        }
        long end = System.currentTimeMillis();
        System.out.println("total time take : " + (end - begin) + " secs");

        return ret;
    }
}