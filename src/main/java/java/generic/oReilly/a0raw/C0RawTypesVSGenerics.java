package java.generic.oReilly.a0raw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin C on 12/7/2015.
 */

/**
 * Created by nichaurasia on Friday, May/15/2020 at 10:26 PM
 */

public class C0RawTypesVSGenerics {
    public static void main(String[] args) {
        rawCollection();
       /*With the help of Generics, the possible runtime Exceptions can be converted to
        Compile time Exceptions */
        genericCollection();//Types Collection
    }

    private static void genericCollection() {
        List<String> strings = new ArrayList();
        strings.add("This");
        strings.add("is a raw List");
        //Gives a compile time exception - java: incompatible types: java.time.LocalDate cannot be converted to java.lang.String
        //strings.add(LocalDate.now());

        //Still a chance of Null pointer exception. Use null check before String operation of s.length()
        strings.add(null);

        System.out.println("From Generic Collection");
        for (String s : strings) {
            if(s != null){
                System.out.printf("%s has %d characters \n", s, s.length());
            }
        }
        System.out.println("***********************");
    }

    private static void rawCollection() {
        List strings = new ArrayList();
        strings.add("This");
        strings.add("is a raw List");
        //This causes runtime exception if the instanceOF check is not performed.
        //strings.add(LocalDate.now());
        //Invokes ClassCastException: class java.time.LocalDate cannot be cast to class java.lang.String

        //Cause of null pointer exception
        // strings.add(null);

        //Wrong data type accepted
        strings.add(3);

        System.out.println("From rawCollection");
        for (Object o : strings) {
            String s = (String) o;
            System.out.printf("%s has %d characters \n", s, s.length());
//            if(null != strings && o instanceof String){
//                String s = (String) o;
//                System.out.printf("%s has %d characters \n",s,s.length());
//            }
        }
        System.out.println("***********************");
    }
}
