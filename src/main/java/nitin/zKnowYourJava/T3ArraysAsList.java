package nitin.zKnowYourJava;

import java.util.Arrays;
import java.util.List;

public class T3ArraysAsList {
    public static void main(String[] args) {
        //arraysAsList();
        List<Integer> numbers = List.of(1, 2, 3,null);//Immutable, add(), set() unsupported
        System.out.println(numbers.getClass());//class java.util.ImmutableCollections$ListN

    }

    private static void arraysAsList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        System.out.println(numbers.getClass());//class java.util.Arrays$ArrayList
        //it is far from immutable. does not support add method

        try {
            numbers.add(4);
            System.out.println("add() supported");
        } catch (Exception e) {
            System.out.println("ArrayList - add unsupported ");
        }

        try {
            numbers.set(2, 2);
            System.out.println("set() supported");
        } catch (Exception ex) {
            System.out.println("set() unsupported");
        }

        System.out.println(numbers);
    }
}
