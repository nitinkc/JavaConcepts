package java;

import java.util.Iterator;
import java.util.Set;

public class MainTest {
    public static void main(String[] args) {
        //com.nitin.a1LambdaExpressions.L0SpottingInvalidLambdas.main(args);
        AccessingAllClassesInPackage accessingAllClassesInPackage = new AccessingAllClassesInPackage();

        Set<Class> set = accessingAllClassesInPackage.findAllClassesUsingClassLoader("com.nitin");

        Iterator itr = set.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
