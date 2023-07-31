package sandbox;

import org.apache.commons.lang3.BooleanUtils;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        removeDigit("133235",'3');
    }

    public static String removeDigit(String number, char digit) {
        //Brute force. Finding all the possibilities exhaustively and keeping the MAX out of all possobolity
        int possibility = -1;
        int idx = number.indexOf(digit); //first indef of
        while(number.indexOf(digit, idx) != -1){
            String tempStr = number;
            StringBuilder sb = new StringBuilder(number);
            sb.setCharAt(idx,Character.MIN_VALUE);
            System.out.println(sb);
            String str = sb.toString();
            int currentPossibility = Integer.parseInt(str);
            possibility = Math.max(possibility, currentPossibility );
            idx = idx+1;
        }
        return String.valueOf(possibility);
    }
}
