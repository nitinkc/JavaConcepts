package java7.a2operators;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 11:18 PM.
 * Only Ternary Operator in Java
 */
public class O11ConditionalTernaryOperator {
    public static void main(String[] args) {
        int a = 10, b = 20;

        int x = (a > b) ? 30 : 40;
        /*
        if (a > b)
            x = 30;
        else
            x = 40;
        */
        System.out.println(x);

        // Nesting of Conditional Operators
        x = (a > 50)? 777 : ((b > 100) ? 888 : 999);
        System.out.println(x);

    }

}
