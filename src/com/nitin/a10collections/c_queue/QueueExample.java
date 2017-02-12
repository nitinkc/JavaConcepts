package com.nitin.a10collections.c_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by nitin.chaurasia on 2/11/2017.
 * peek() Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
 * poll() Retrieves and removes the head of this queue, or returns null if this queue is empty.
 * remove() Removes a single instance of the specified element from this queue, if it is present.
 */
public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            q.add((int) (i));
        }

        System.out.println("Peek at the element at the head without taking the element out of the queue with element method");
        // peek at the element at the head without taking the element out of the queue
        // element() method
        System.out.println(q.element());

        System.out.println("After Polling");
        for (int i :
                q) {
            System.out.print(i + "\t");
        }

        q.remove();
        q.poll();

        // To remove element, u
        System.out.println();
        Iterator<Integer> itr = q.iterator();
        while (itr.hasNext()) {
            int element = itr.next();
            {
                if (element == 6) {
                    itr.remove();
                    continue;
                }
                System.out.print(element + "\t");
            }
        }
    }
}
