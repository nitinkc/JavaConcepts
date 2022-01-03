package nitin.a2operators;

/**
 * Created by Nitin Chaurasia on 12/27/16 at 1:03 AM.
 * 2 Types of Numeric Type Casting
 * Implicit Type Casting :
 *    Also known as WIDENING OR UP-CASTING
 *    Compiler is responsible for typecasting.
 *    Happens when assigning smaller data type value to a bigger data type variable
 *    No loss of information
 * Explicit Type Casting
 *    Also known as NARROWING OR DOWN-CASTING
 *    Programmer is responsible
 *    Happens when assigning bigger data type value to a smaller data type variable
 *    Chance of loss of precision/info.
 */
public class O9TypeCastingNumericPromotion {
    public static void main(String[] args) {

        /***** Implicit Type Casting *****/
        // byte(1B) -> short(2B) -> int(4B) -> long(4B) -> float(4B) -> double(8B)
        double d = 10;
        System.out.println(d);//compiler converts int 10, to double automatically

        // char(2B) -> int(4B) -> long(4B) -> float(4B) -> double(8B)
        int i = 'a';
        System.out.println(i);//compiler converts char to int automatically

        /***** explicit Type Casting *****/
        // byte(1B) <- short(2B) <- int(4B) <- long(4B) <- float(4B) <- double(8B)
        byte b = (byte)130; // Most Significant bit is lost
        System.out.println(b); // See notes for the detailed explanation

        int j = 150;
        short s = (short) j;
        System.out.println(s);//150

        // Double : digits after the decimal points are lost
        double x = 130.456;
        int y = (int) x;
        byte z = (byte) x;
        System.out.println(y);//130
        System.out.println(z);//-126


    }
}
