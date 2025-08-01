package com.utilities;

import java.util.Arrays;
import lombok.NoArgsConstructor;

/** Created by nichaurasia on Saturday, April/25/2020 at 3:46 AM */
@NoArgsConstructor
public class StringUtility {
    public static boolean isEmpty(String obj) {
        return obj == null || "".equals(obj.trim());
    }

    public static boolean isNotEmpty(String obj) {
        return obj != null && !"".equals(obj.trim());
    }

    public static String trimToLength(String input, int length) {
        if (!isEmpty(input)) {
            input = input.trim();
            if (input.length() > length) {
                return input.substring(0, length);
            }
        }
        return input;
    }

    public static String sortString(String str) {
        char[] temp = str.toLowerCase().toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
