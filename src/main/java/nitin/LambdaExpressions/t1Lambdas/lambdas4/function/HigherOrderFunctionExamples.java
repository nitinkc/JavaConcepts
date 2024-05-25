package nitin.LambdaExpressions.t1Lambdas.lambdas4.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static nitin.LambdaExpressions.t1Lambdas.lambdas4.function.FunctionUtils.*;

public class HigherOrderFunctionExamples {
    private static final List<Employee> employees = EmployeeSamples.getSampleEmployees();
    private static final List<String> words =
            Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");

    private HigherOrderFunctionExamples() {
    }

    public static void main(String[] args) {
        //predicateExamples();
        //allMatch2Examples();
        //transformExamples();
        //transform2Examples();
        //consumerExamples();
        customHigherOrderFunctionExamples();
    }

    public static void predicateExamples() {
        Predicate<Employee> isRich = e -> e.getSalary() > 200000;
        Predicate<Employee> isEarly = e -> e.getEmployeeId() <= 10;
        System.out.printf("Rich employees: %s.%n", allMatches(employees, isRich));
        System.out.printf("Employees hired early: %s.%n", allMatches(employees, isEarly));
        System.out.printf("Employees that are rich AND hired early: %s.%n", allMatches(employees, isRich.and(isEarly)));
        System.out.printf("Employees that are rich OR hired early: %s.%n", allMatches(employees, isRich.or(isEarly)));
        System.out.printf("Employees that are NOT rich: %s.%n", allMatches(employees, isRich.negate()));
        Employee polly = employees.get(1);
        Predicate<Employee> isPolly = Predicate.isEqual(polly);
        System.out.printf("Employees in list that are 'equals' to Polly Programmer: %s.%n", allMatches(employees, isPolly));
    }

    public static void allMatch2Examples() {
        System.out.printf("Original words: %s.%n", words);
        List<String> hWords = allMatches2(words, word -> word.contains("h"));
        System.out.printf("Words with h: %s.%n", hWords);
        List<String> hlWords = allMatches2(words, word -> word.contains("h"),
                word -> word.contains("l"));
        System.out.printf("Words with h and l: %s.%n", hlWords);
        List<String> hlShortWords = allMatches2(words, word -> word.contains("h"),
                word -> word.contains("l"),
                word -> word.length() <= 4);
        System.out.printf("Words with h and l and length <= 4: %s.%n", hlShortWords);
    }

    public static void transformExamples() {
        System.out.printf("Original words: %s.%n", words);
        Function<String, String> makeUpperCase = String::toUpperCase;
        List<String> upperCaseWords = transform(words, makeUpperCase);
        System.out.printf("Uppercase: %s.%n", upperCaseWords);
        Function<String, String> makeExciting = word -> word + ": Wow!";
        List<String> excitingWords = transform(words, makeExciting);
        System.out.printf("Exciting: %s.%n", excitingWords);
        Function<String, String> makeBoth1 = makeExciting.compose(makeUpperCase);
        List<String> excitingUpperCaseWords1 = transform(words, makeBoth1);
        System.out.printf("Exciting uppercase[1]: %s.%n", excitingUpperCaseWords1);
        Function<String, String> makeBoth2 = makeUpperCase.andThen(makeExciting);
        List<String> excitingUpperCaseWords2 = transform(words, makeBoth2);
        System.out.printf("Exciting uppercase[2]: %s.%n", excitingUpperCaseWords2);
    }

    public static void transform2Examples() {
        System.out.printf("Original words: %s.%n", words);
        Function<String, String> makeUpperCase = String::toUpperCase;
        List<String> upperCaseWords = transform2(words, makeUpperCase);
        System.out.printf("Uppercase: %s.%n", upperCaseWords);
        Function<String, String> makeExciting = word -> word + ": Wow!";
        List<String> excitingWords = transform2(words, makeExciting);
        System.out.printf("Exciting: %s.%n", excitingWords);
        List<String> excitingUpperCaseWords = transform2(words, makeExciting, makeUpperCase);
        System.out.printf("Exciting uppercase: %s.%n", excitingUpperCaseWords);
    }

    public static void consumerExamples() {
        List<Employee> myEmployees = Arrays.asList(new Employee("Bill", "Gates", 1, 200000),
                new Employee("Larry", "Ellison", 2, 100000));
        System.out.println("Original employees:");
        processEntries(myEmployees, System.out::println);
        Consumer<Employee> giveRaise = e -> e.setSalary(e.getSalary() * 11 / 10);
        System.out.println("Employees after raise:");
        processEntries(myEmployees, giveRaise.andThen(System.out::println));
    }

    public static Predicate<Employee> buildIsRichPredicate(double salaryLowerBound) {
        return (e -> e.getSalary() > salaryLowerBound);
    }

    public static void customHigherOrderFunctionExamples() {
        List<Employee> richEmployees1 = allMatches(employees, buildIsRichPredicate(200_000));
        System.out.printf("Rich employees [via method that returns Predicate]: %s.%n", richEmployees1);
        Function<Integer, Predicate<Employee>> makeIsRichPredicate = salaryLowerBound -> (e -> e.getSalary() > salaryLowerBound);
        List<Employee> richEmployees2 = allMatches(employees, makeIsRichPredicate.apply(200_000));
        System.out.printf("Rich employees [via Function that returns Predicate]: %s.%n", richEmployees2);
    }
}
