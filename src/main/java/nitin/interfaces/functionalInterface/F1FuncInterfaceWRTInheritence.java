package nitin.interfaces.functionalInterface;

/**
 * Created by Nitin Chaurasia on 1/30/18 at 10:46 AM.
 */

// SAM -> Single Abstract Method & Default and Static methods can be declared
@FunctionalInterface
interface FuncInterfaceWRTInheritence {
    void m1();

    //Can declare any number of default and static methods in a Functional Interface
    default int m2(){
        return 2;
    }

    static void m3(){
        System.out.println("Can declare any number of default and static methods in a Functional Interface");
    }
}


// In the child interface we can define exactly same parent interface abstract method.
@FunctionalInterface
interface ChildFuncInterfaceWRTInheritence extends FuncInterfaceWRTInheritence{
    //No Compile Time Error
    void m1();

    // In the child interface we can’t define any new abstract methods otherwise child interface won’t be Functional
    // Interface and if we are trying to use @Functional Interface annotation then compiler gives an error message.
    /* public void m2(); */
    // ChildFuncInterfaceWRTInheritence is not a functional interface
    // multiple non-overriding abstract methods found in interface
}

@FunctionalInterface
interface emptyFunctionalInterface{
    // Exactly one abstract method is compulsory else Compile time Exception.
    void test();
}
