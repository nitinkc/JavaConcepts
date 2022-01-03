package nitin.generic.boundedType;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, September/29/2020 at 2:29 AM
 */

public class Runner {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        //integerBox.setT(new Integer(10));
        //integerBox.inspect("some text"); // error: this is still String!
        System.out.println("Test");
        //integerBox.inspect(new Number(10));

    }
}