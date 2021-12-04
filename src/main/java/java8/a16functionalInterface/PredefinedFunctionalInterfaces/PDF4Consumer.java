package java8.a16functionalInterface.PredefinedFunctionalInterfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 10:09 PM.
 * Created by Nitin C on 3/3/2016.
 * Consumer and BiConsumer (Bi means 2 variables)
 * HAs a method accept
 * Use Consumer when you want to do something with the parameter
 * Ex: we use Consumer with forEach
 * a_list.forEach(System.out :: print);
 * OR
 * Consumer<String> c1 = System.out::println;
 * a_list.forEach(c1);
 * Consumer<String> c2 = x -> System.out.println(x);
 */
public class PDF4Consumer {
    public static void main(String[] args) {

        Consumer<String> c = s -> System.out.println(s);
        c.accept("Nitin");
        c.accept("Kirti");

        Map<String,Integer> map = new HashMap<>();
        BiConsumer<String,Integer> b1 = map::put;
        BiConsumer<String,Integer> b2 = (k,v) -> map.put(k,v);

        b1.accept("Chicken", 1);
        b2.accept("Mutton", 2);
        System.out.println(map);
    }
}
