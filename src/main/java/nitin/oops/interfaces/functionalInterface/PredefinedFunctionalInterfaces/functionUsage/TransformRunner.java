package nitin.oops.interfaces.functionalInterface.PredefinedFunctionalInterfaces.functionUsage;

import com.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformRunner {
    public static void main(String[] args) {
        TransformExecutor<String,String> transformExecutor = new TransformExecutor();
        String str = "Test";

        String result = transformExecutor.transformString(str, x -> x.toUpperCase());
        System.out.println(result);
    }
}
