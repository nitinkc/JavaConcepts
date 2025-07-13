package nitin.collections.linkedList;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Adding elements to the LinkedList
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.add("Date");

        // Displaying the LinkedList
        System.out.println("LinkedList: " + linkedList);

        // Adding elements at specific positions
        linkedList.add(2, "Grape");
        linkedList.addFirst("Apricot");
        linkedList.addLast("Fig");

        // Displaying the updated LinkedList
        System.out.println("Updated LinkedList: " + linkedList);

        // Getting elements by index
        String secondElement = linkedList.get(1);
        System.out.println("Second element: " + secondElement);

        // Removing elements
        linkedList.remove("Banana");
        linkedList.remove(3);

        // Displaying the final LinkedList
        System.out.println("Final LinkedList: " + linkedList);
    }
}
