package nitin.oops.interfaces.functionalInterface.functionaInterfaceWithLambda;

/**
 * Created by Nitin Chaurasia on 3/3/16 at 12:23 AM.
 * If an interface contain only one abstract method, such type of interfaces are called functional
 * interfaces and the method is called functional method or single abstract method (SAM). 

 * Inside functional interface in addition to single Abstract method (SAM) we can write any number of
 * default and static methods 
 *
 * Java 8  introduced @Functional Interface annotation

 */
@FunctionalInterface
public interface CheckTrait {
    boolean test(Animal a);
}
