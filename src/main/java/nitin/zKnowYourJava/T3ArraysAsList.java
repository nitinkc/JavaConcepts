package nitin.zKnowYourJava;

import java.util.Arrays;
import java.util.List;

public class T3ArraysAsList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3);
        System.out.println(numbers.getClass());//class java.util.Arrays$ArrayList
        //it is far from immutable. does not support add method

        try{
            numbers.add(4);
        } catch (Exception e){
            System.out.println("add unsupported ");
        }

        try{
            numbers.set(2,2);
        } catch (Exception ex){
            System.out.println("set unsupported");
        }

        System.out.println(numbers);
    }
}
