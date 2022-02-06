package nitin.LambdaExpressions.t1Lambdas.lambdas3.function;

public class RandomEmployees {
    public static void main(String[] args) {
        System.out.printf("%nSupplier Examples%n");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Random person: %s.%n", EmployeeUtils.randomPerson());
        }
    }
}
