package nitin.LambdaExpressions.methodRef;

import java.util.function.BiFunction;

public class MethodReferences {

    //Static method Demonstration to be called as MethodReferences::staticAppendStrings
    public static String staticAppendStrings(String a, String b) {
        return a + b;
    }

    public <T> T playBiFunction(T a, T b, BiFunction<T, T, T> biFunction) {
        return biFunction.apply(a, b);
    }

    //Instance method
    public void myMethod(int a, int b, Display display) {
        System.out.println("method reference in java 8 : ");
        display.displayResults(a, b);
    }

    public String appendStrings(String a, String b) {
        return a.concat(b);
    }

    public void myMethod(int a, int b) {
        System.out.println("method reference in java 8 : " + a + b);
    }
}
