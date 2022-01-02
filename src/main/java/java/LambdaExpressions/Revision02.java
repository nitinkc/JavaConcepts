package java.LambdaExpressions;

/**
 * Created by nitin on Tuesday, February/04/2020 at 1:25 AM
 *
 * Define a functional Interface and provide its implementation via a Lambda
 */
public class Revision02 {
    public static void main(String[] args) {
        //Providing the implementation of the SAM of Functional Interface via a Lambda
         TestInterface t = (x, y) -> x + y;

         //Call the method
        System.out.println(t.method("Nitin",": Chaurasia"));

        //Changing the definiton
        t = (str1,str2) -> str1.toUpperCase() + " <> " + str2.substring(3);
        System.out.println(t.method("Nitin",": Chaurasia"));

    }
}

@FunctionalInterface
interface TestInterface{
    String method(String str1, String str2);
}
