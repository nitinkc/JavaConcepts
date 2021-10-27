package com.test;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class NullabilityTest {
    public static void main(String[] args) {

        String getOrderStopDate = null;//"Nitin";

        System.out.println(Optional.ofNullable(getOrderStopDate).map(StringUtils::upperCase).orElse(null));
    }
}
