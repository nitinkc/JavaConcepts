package java8.a16functionalInterface.functionaInterfaceWithLambda;

/**
 * Created by Nitin C on 3/5/2016.
 *
 * Java compiler implicitly assumes any interface that contains exactly one abstract method as functional Interface
 */

@FunctionalInterface
public interface Sprint {
    void sprint(Animal animal);

}
