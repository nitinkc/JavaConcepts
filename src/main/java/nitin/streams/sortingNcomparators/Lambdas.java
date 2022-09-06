package nitin.streams.sortingNcomparators;

import com.entity.EmployeeSimple;

import java.util.Comparator;
import java.util.function.Predicate;

/**
 * @author Created by nichaurasia
 * Created on Sunday, September/27/2020 at 4:59 PM
 */

public class Lambdas {

    public static final Comparator<EmployeeSimple> ageLambda = (e1, e2) -> e1.getAge() - e2.getAge();

    public static final Comparator<EmployeeSimple> ageLambdaOld = new Comparator<EmployeeSimple>() {
        @Override
        public int compare(EmployeeSimple o1, EmployeeSimple o2) {
            return o1.getAge() - o2.getAge();
        }
    };
    public static final Comparator<EmployeeSimple> revAgeLambda = (e1, e2) -> e2.getAge() - e1.getAge();

    public static final Comparator<EmployeeSimple> salaryLambda = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());

    //Predicates
    public static final Predicate<EmployeeSimple> ageGT30Predicate = e -> e.getAge() > 30;


    private Lambdas() {
    }
}
