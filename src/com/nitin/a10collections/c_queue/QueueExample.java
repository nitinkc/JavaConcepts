package com.nitin.a10collections.c_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by nitin.chaurasia on 2/11/2017.
 */
public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            q.add((int) (i));
        }

        System.out.println("Polling");
        q.poll();

        System.out.println("After Polling");
        for (int i:
                q) {
            System.out.println(i);

        }
    }
}
