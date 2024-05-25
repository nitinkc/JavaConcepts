package nitin.LambdaExpressions.methodRef.ex3;

import com.entity.EmployeeSimple;
import com.entity.SampleData;
import org.apache.commons.math3.util.MathUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Runner {

    public void runMeFirst() {
        MethodRefTest methodRefTest = new MethodRefTest();

        System.out.println(methodRefTest.testMethodRef("John", "Doe", (p, q) -> p.concat(q)));
        System.out.println(methodRefTest.testMethodRef("John", "Doe", (String::concat)));

        //Reference to a static method
        System.out.println(methodRefTest.testMethodRef(3.0, 4.0, (a, b) -> findHypotenous(a, b)));
        System.out.println(methodRefTest.testMethodRef(3.0, 4.0, Math::hypot));//Static
        System.out.println(methodRefTest.testMethodRef(3.0, 4.0, MathUtils::normalizeAngle));

        ObjectTypeTest obj = new ObjectTypeTest();
        //Ref. to an instance method of a particular a5object
        System.out.println(methodRefTest.testMethodRef("John", "Doe", (p, q) -> obj.appendAndCapitalize(p, q)));
        System.out.println(methodRefTest.testMethodRef("John", "Doe", obj::appendAndCapitalize));
        System.out.println(methodRefTest.testMethodRef(3.0, 4.0, this::findHypotenous));//using this

        //Ref. to an instance method of an arbitrary a5object of a particular type
        System.out.println(methodRefTest.testMethodRef("Jane", "Doe", (p, q) -> p.concat(q)));
        System.out.println(methodRefTest.testMethodRef("Jane", "Doe", String::concat));
    }

    public void runMe() {
        System.out.println("*********************************************************");
        List<EmployeeSimple> list = SampleData.getSimpleEmployees();
        //Ref. to an instance method of an arbitrary a5object of a particular typ
        list.forEach(emp -> emp.printNameWithSalary());
        System.out.println("--------------------------------------------------------");
        Predicate<EmployeeSimple> notNull = Objects::nonNull;
        Predicate<EmployeeSimple> notEmptyName = emp -> (null != emp.getName());
        Predicate<EmployeeSimple> notEmptySalary = emp -> (null != emp.getSalary());
        Predicate<EmployeeSimple> notEmptyAge = emp -> (null != emp.getAge());

        Supplier<List<SimpleEmployee>> supplier = ArrayList::new;
        Transformer transformer = new Transformer();

        List<SimpleEmployee> simpleEmployeeList = list.stream()
                //.filter(notNull.and(notEmptyName).and(notEmptySalary).and(notEmptyAge))
                .filter(((Predicate<EmployeeSimple>) Objects::nonNull)// use inline Predicate by casting the Predicate
                        .and(emp -> (null != emp.getName()))
                        .and(emp -> (null != emp.getSalary()))
                        .and(emp -> (null != emp.getAge()))
                )
                //.map(emp -> transformer.getEmployee(emp))
                .map(transformer::getEmployee)
                .sorted(Comparator.comparing(SimpleEmployee::getSalary).reversed())
                .collect(Collectors.toList());

        //Find diff between list.stream.sorted vs list.sort
        simpleEmployeeList.forEach(SimpleEmployee::printMe);

        //What is static factory
        simpleEmployeeList.sort(Comparator.comparing(SimpleEmployee::getSalary).reversed());
    }

    private Double findHypotenous(Double a, Double b) {
        return Math.hypot(a, b);
    }
}
