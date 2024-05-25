package nitin.a6oops.polymorphism.overloading;

/**
 * Created by nitin.chaurasia on 3/4/2017.
 * <p>
 * Static polymorphism in Java is achieved by method overloading
 * compile time polymorphism or static binding
 * uses type information (class in Java) for binding
 * private, static, final, static variables } methods, not participation in polymorphism
 */
public class P2StaticBinding {
    public static void main(String[] args) {

        DemoOverload demo = new DemoOverload();

        System.out.println(demo.add(2, 3));      //method 1 called

        System.out.println(demo.add(2, 3, 4));    //method 2 called

        System.out.println(demo.add(2, 3.4));    //method 4 called

        System.out.println(demo.add(2.5, 3));    //method 3 called

        // Detected during Complier time. CE: No suitable method found for add(String)
        //System.out.print(demo.add("Nitin"));

    }
}

class DemoOverload {

    public int add(int x, int y) {  //method 1

        return x + y;

    }

    public int add(int x, int y, int z) { //method 2

        return x + y + z;

    }

    public int add(double x, int y) { //method 3

        return (int) x + y;

    }

    public int add(int x, double y) { //method 4

        return x + (int) y;

    }

}

