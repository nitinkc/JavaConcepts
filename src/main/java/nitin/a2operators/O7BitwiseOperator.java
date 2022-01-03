package nitin.a2operators;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 10:18 PM.
 * & -> AND : If both operands are true, result is True
 * | -> OR  : if atleast 1 operand is T, result is True
 * ^ -> XOR : if both operands are different, result is True
 * ~ -> Complement : can't be applied to boolean
 * ! -> Boolean Complement
 */
public class O7BitwiseOperator {

    public static void main(String[] args) {

        System.out.println(true & true);
        System.out.println(true | true);
        System.out.println(true ^ true);
        // System.out.println(~true);// cant be applied
        System.out.println(!true);// False

        // Mathematical manipulations
        System.out.println(4 & 5);//100 & 101 = 100
        System.out.println(4 | 5);//100 | 101 = 101
        System.out.println(4 ^ 5);//100 ^ 101 = 001
        System.out.println(~4);// minus 4
    }
}
