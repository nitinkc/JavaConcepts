package com.nitin.a.sandBox;

import java.text.DecimalFormat;

public class StringFormating4Currency {
    public static void main(String[] args) {
        String number = "123456.574";
        double amount = Double.parseDouble(number);
        DecimalFormat formatter = new DecimalFormat("#,###.00");

        System.out.println(formatter.format(amount));
        System.out.println(formatter.format(amount).toString());

    }
}
