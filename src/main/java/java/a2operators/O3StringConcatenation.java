package java.a2operators;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 9:46 PM.
 */
public class O3StringConcatenation {
    public static void main(String[] args) {
        String str = "Nitin";
        int a = 10, b = 20, c = 30;

        // Concatenation in action
        // Before the String, the arithmatic operations gets performed.
        System.out.println(a+b+c+str);//60Nitin
        System.out.println(a+str+b+c);//10Nitin2030
        System.out.println(a+b+str+c);//30Nitin30
        System.out.println(str+a+b+c);//Nitin102030
    }
}
