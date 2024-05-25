package nitin.a6oops.polymorphism.overriding;

/**
 * Created by Nitin Chaurasia on 2/1/18 at 4:57 PM.
 * From 1.5 Covariant Return type is Valid
 */
public class P4CovariantReturn {
    public static void main(String[] args) {
        P p = new C();
        p.m1();// m1 of C to be called due to late binding
        System.out.println("Testing Covariant return type");
    }
}

class P {
    public Object m1() {
        return null;
    }
}

class C extends P {
    //Covariant return type (String is child of Object)
    public String m1() {
        return null;
    }
}