package nitin.LambdaExpressions.methodRef;

public class Example {

    public static void main(String[] args) {
        //Declare the Lambda directly
        Display<Integer> displayDeclaredHere = (a, b) -> System.out.println("method reference in java 8 : " + (a + b));
        displayDeclaredHere.displayResults(5,55);

        //extracted method
        Display displayExtractedSameClass = getDisplay();//this::getDisplay works with non-static classes
        displayExtractedSameClass.displayResults(10,20);

        //Taking the definition into another class, or using another class to define the interface
        MethodReferences obj = new MethodReferences();
        // Reference to the method using the object of the class myMethod
        Display<Integer> displayInstanceMethodParticularObject = ((a,b) -> obj.myMethod(a,b));//putting the definition in object of another class
        // Calling the method inside the functional interface Display
        displayInstanceMethodParticularObject.displayResults(1,3);

        Display<Integer> displayReferenceInstanceMethodParticularObject = obj::myMethod;//calling the same via method reference
        displayReferenceInstanceMethodParticularObject.displayResults(6,6);
    }

    private static Display getDisplay() {
        return (a, b) -> System.out.println("method reference in java 8 : " + a + b);
    }
}

@FunctionalInterface
interface Display<T> {
    void displayResults(T a, T b);
}

