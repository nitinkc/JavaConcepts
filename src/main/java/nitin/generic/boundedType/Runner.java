package nitin.generic.boundedType;

/**
 * @author Created by nichaurasia
 * Created on Tuesday, September/29/2020 at 2:29 AM
 */

public class Runner {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.setT(Integer.valueOf(10));
        //integerBox.inspect("some text"); // error: this is still String!
        System.out.println("Test");
        integerBox.inspect(Integer.valueOf(10));

    }
}