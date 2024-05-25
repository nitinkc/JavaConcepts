package nitin.LambdaExpressions.methodRef;

import com.entity.EmployeeSimple;
import com.entity.SampleData;

import java.io.PrintStream;
import java.util.List;

public class Example2 {

    public static void main(String[] args) {
        MethodReferences myApp = new MethodReferences();

        // Calling the method with a lambda expression
        System.out.println(myApp.playBiFunction("Hello ", "World!", (a, b) -> a.concat(b)));
        // Reference to an instance method of an **arbitrary a5object** of a particular type
        System.out.println(myApp.playBiFunction("Hello ", "World!", String::concat));
        // Reference to an **instance method** of a particular a5object
        System.out.println(myApp.playBiFunction("Hello ", "World!", ((a, b) -> myApp.appendStrings(a, b))));
        System.out.println(myApp.playBiFunction("Hello ", "World!", myApp::appendStrings));

        // Reference to a static method
        System.out.println(myApp.playBiFunction("Hello ", "World!", MethodReferences::staticAppendStrings));

        // Calling Static method From Math Library
        System.out.println(myApp.playBiFunction(3.0, 4.0, (x, y) -> Math.hypot(x, y)));
        // Reference to a static method
        System.out.println(myApp.playBiFunction(3.0, 4.0, Math::hypot));

        /************************************* ANOTHER EXAMPLE *****************************************************/
        List<EmployeeSimple> list = SampleData.getSimpleEmployees();
        PrintStream printStream = System.out;
        // Reference to an **instance method** of a particular a5object
        list.forEach(printStream::println);

        //Reference to an Instance Method of an Arbitrary Object of a Particular Type
        list.forEach(EmployeeSimple::printNameWithSalary);
    }
}
