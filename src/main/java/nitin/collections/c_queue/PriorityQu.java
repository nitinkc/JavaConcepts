package nitin.collections.c_queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Heaps are represented using Priority Queue. It gives O(1) seek time
 * add(E e) Inserts the specified element into this priority queue.
 * offer(E e) Inserts the specified element into this priority queue
 * poll() Retrieves and removes the head of this queue, or returns null if this queue is empty.
 */

public class PriorityQu {
    public static void main(String[] args) {
        int[] q = {5, 3, 8, 6, 9, 1, 7};
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : q) {
            pq.offer(i);//Add values
        }

        System.out.println("Printing Priority Queue");
        System.out.println(pq); //Print directly

        for (int j : q) {
            System.out.print(" " + pq.poll());//Poll removes the elements
        }

        //pqWithSort(q);
    }

    private static void pqWithSort(int[] q) {
        PQsort pqs = new PQsort();
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs);
        for (int x : q) // load queue
            pq2.offer(x);
        System.out.println("\nsize " + pq2.size());
        System.out.println("peek " + pq2.peek());
        System.out.println("size " + pq2.size());
        System.out.println("poll " + pq2.poll());
        System.out.println("size " + pq2.size());

        for (int k : q) // review queue
            System.out.print(pq2.poll() + " ");
    }

    static class PQsort implements Comparator<Integer> {
        public int compare(Integer one, Integer two) {
            return one - two;
        }
    }
}
