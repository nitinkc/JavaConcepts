package nitin.LambdaExpressions.methodRef.ex3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleEmployee {
    private String name;
    private String jobLevel; // level + exp + age
    private String salary;

    public void printMe() {
        String sb = this.getName() + " " + this.getJobLevel() + " " + this.getSalary() + " ";

        System.out.println(sb);
    }
}
