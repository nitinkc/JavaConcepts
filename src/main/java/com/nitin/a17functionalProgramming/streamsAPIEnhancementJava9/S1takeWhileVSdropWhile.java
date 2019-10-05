package com.nitin.a17functionalProgramming.streamsAPIEnhancementJava9;

import entity.Cargo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nitin Chaurasia on 2/1/18 at 1:41 AM.
 *
 * takeWhile() like filter() method will take elements from the Stream as long as predicate returns true.
 * If predicate returns false, at that point onwards remaining elements won't be processed,
 * i.e rest of the Stream is discarded.
 */
public class S1takeWhileVSdropWhile {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {            list.add(i);
        }

       //list = Cargo.intCargo(6);

        System.out.println(list);
       //filtering the even elements out
        List<Integer> l = list
                .stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(l);

        //filtering the even elements out using takeWhile (Fails after fulfilling first condition)
        List<Integer> l2 = list
                .stream()
                .filter(x -> x%3==0)
                .takeWhile(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(l2);

        // drop while is opposite to take while
        List<Integer> l3 = list
                .stream()
                .dropWhile(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(l3);

    }
}
