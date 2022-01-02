package java.LambdaExpressions.t1Lambdas.lambdas3.integrable;

public class IntegrationTest {
  public static void main(String[] args) {
    MathUtilities.printExpectedAnswer(10, 100, "x^2", "100^3/3 - 10^3/3", 
                                      Math.pow(100,3)/3.0 - Math.pow(10,3)/3.0);
    MathUtilities.integrationTest(x -> x*x, 10, 100);
    MathUtilities.printExpectedAnswer(50, 500, "x^3", "500^4/4 - 50^4/4", 
                                      Math.pow(500,4)/4.0 - Math.pow(50,4)/4.0);
    MathUtilities.integrationTest(x -> Math.pow(x,3), 50, 500);
    MathUtilities.printExpectedAnswer(0, Math.PI, "sin(x)", "-cos(pi) - -cos(0)", 
                                      -Math.cos(Math.PI) - -Math.cos(0));
    MathUtilities.integrationTest(x -> Math.sin(x), 0, Math.PI);
    System.out.println("Alternative representation");
    MathUtilities.integrationTest(Math::sin, 0, Math.PI);
    MathUtilities.printExpectedAnswer(2, 20, "e^x", "e^20 - e^2", 
                                      Math.pow(Math.E, 20) - Math.pow(Math.E, 2));
    MathUtilities.integrationTest(x -> Math.exp(x), 2, 20);
    System.out.println("Alternative representation");
    MathUtilities.integrationTest(Math::exp, 2, 20);
  }
}
