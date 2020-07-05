package com.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cargo {

    public static List<Integer> intCargo(int numberOfElements){

        Random r = new Random(9999);
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            ret.add(r.nextInt());
        }

        return ret;
    }


    public static List<Integer> intCargoSequence(int start, int end) {
        List<Integer> ret = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            ret.add(i);
        }
        return ret;
    }
}
