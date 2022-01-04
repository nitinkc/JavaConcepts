package nitin;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class MainTest {
    public static void main(String[] args) throws IOException {
        AccessingAllClassesInPackage accessingAllClassesInPackage = new AccessingAllClassesInPackage();

        //Set<Class> set = accessingAllClassesInPackage.findAllClassesUsingClassLoader("nitin");
        //Set<Class> set = accessingAllClassesInPackage.findAllClassesUsingGoogleGuava("nitin");
        Set<Class> set = accessingAllClassesInPackage.findAllClassesUsingReflectionsLibrary("nitin");


        Iterator itr = set.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
