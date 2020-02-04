package com.nitin.a19CalanderNCurrency.currency;

import org.apache.commons.lang3.math.NumberUtils;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class StringFormating4Currency {
    public static void main(String[] args) {
        List<String> number = Arrays.asList("123456.574", "123456789.57445", "12.00", "123", "0.00", null, "test default value");

        for (String temp : number) {
            // Double.parseDouble does not handle null pointer or number pointer exception
            //double amount = Double.parseDouble(temp);
            double amount = NumberUtils.toDouble(temp,-1L);
            //DecimalFormat formatter = new DecimalFormat("#,###.00");
            NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

            System.out.println(formatter.format(amount));
            //System.out.println(formatter.format(amount).toString());
        }
    }
}
