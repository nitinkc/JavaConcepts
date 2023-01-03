package nitin.LambdaExpressions.methodRef.ex3;

import com.entity.EmployeeSimple;

public class Transformer {

    public final String SPACE = " ";

    public SimpleEmployee getEmployee(EmployeeSimple emp) {
        // EmployeeSimple -> Simpleemployee conversion
        SimpleEmployee simpleEmployee = SimpleEmployee.builder()
                .name(emp.getName())
                .jobLevel(Character.toString(emp.getLevel()) +SPACE+
                        Integer.toString(emp.getExperience()) +SPACE+
                        Integer.toString(emp.getAge()))
                .salary(Double.toString(emp.getSalary()))
                .build();
        return simpleEmployee;
    }
}
