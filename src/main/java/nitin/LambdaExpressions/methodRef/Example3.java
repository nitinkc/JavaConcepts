package nitin.LambdaExpressions.methodRef;

import java.util.Arrays;
import java.util.List;

public class Example3 {
    public static void main(String args[]) {
        final List<Person> people = Arrays.asList(new Person("dan"), new Person("laura"));
        // Method reference
        people.forEach(Person::printName);
        // Lambda expression
        people.forEach(person -> person.printName());
    }
}
