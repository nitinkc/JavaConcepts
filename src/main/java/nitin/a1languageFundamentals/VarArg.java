package nitin.a1languageFundamentals;

/**
 * Created by Nitin Chaurasia on 12/28/16 at 1:04 AM.
 * Declare a method with variable number of Arguments
 * Since V1.5
 * m(int... x) &amp; m(int x...) - ONLY TWO WAYS OF DECLARATION
 * Only one Var-Arg parameter is allowed, also it should be last - m(String s, int... x)
 * internally its implemented by 1D Array
 * var-arg will get least priority. similar to default in Switch
 */
public class VarArg {
    public static void main(String[] args) {
        varArgMethod(10);// non var agr gets priority
        varArgMethod(10,20);
        varArgMethod(10,20,30);
        varArgMultiple("Nitin", 10,20);
    }

    // non var arg method
    static void varArgMethod(int x){
        System.out.println(x);
    }
    // Variable number of arguments including zero
    static void varArgMethod(int... x){
        System.out.println("From Var Arg. Stores the argument in an array");
        System.out.println(x.length);
    }

    static void varArgMultiple(String name, float... y){
        System.out.println(name);
        for (float i : y){
            System.out.println(i);
        }
    }
}
