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
    private String jobLevel;//level + exp + age
    private String salary;

    public void printMe(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" ");
        sb.append(this.getJobLevel()).append(" ");
        sb.append(this.getSalary()).append(" ");

        System.out.println(sb.toString());
    }
}
