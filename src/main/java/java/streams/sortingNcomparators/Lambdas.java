package java.streams.sortingNcomparators;

import java.util.Comparator;
import java.util.function.Predicate;

/**
 * @Author Created by nichaurasia
 * @create on Sunday, September/27/2020 at 4:59 PM
 */

public class Lambdas {

    public static final Comparator<Employee> ageLambda = (e1,  e2) -> e1.getAge() - e2.getAge();

    public static final Comparator<Employee> ageLambdaOld = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge() - o2.getAge();
        }
    };
    public static final Comparator<Employee> revAgeLambda = (e1,  e2) -> e2.getAge() - e1.getAge();

    public static final Comparator<Employee> salaryLambda = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());

    //Predicates
    public static final Predicate<Employee> ageGT30Predicate = e -> e.getAge() > 30;


    private Lambdas(){}
}
