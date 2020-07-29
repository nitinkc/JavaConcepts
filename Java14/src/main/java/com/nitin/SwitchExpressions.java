package com.nitin;

/**
 * Created by Nitin Chaurasia on Friday, June/05/2020 at 2:52 AM
 */

public class SwitchExpressions {
    public static void main(String[] args) {
        String day = "sun";

        String result = switch (day) {
            case "M", "W", "F" -> "Monday Wednesday Friday";
            case "Tuesday", "TH", "Sat" -> "Tuesday Thursday Saturday";
            default -> {
                if(day.isEmpty())
                    yield "Please insert a valid day";
                else
                    yield "Sunday";
            }
        };
        System.out.println(result);
    }
}
