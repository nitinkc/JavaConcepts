package nitin.a6oops.interfaces.functionalInterface.PredefinedFunctionalInterfaces.functionUsage;

public class TransformRunner {
    public static void main(String[] args) {
        TransformExecutor<String, String> transformExecutor = new TransformExecutor();
        String str = "Test";

        String result = transformExecutor.transformString(str, x -> x.toUpperCase());
        System.out.println(result);
    }
}
