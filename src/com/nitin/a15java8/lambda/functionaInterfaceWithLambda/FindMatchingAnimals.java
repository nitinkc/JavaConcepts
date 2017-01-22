package com.nitin.a15java8.lambda.functionaInterfaceWithLambda;

/**
 * Created by Nitin Chaurasia on 5/9/16 at 10:49 PM.
 */
public class FindMatchingAnimals {

    public static void main(String[] args) {
        print(new Animal("Fish", false, true), a -> a.isCanHop());
        print(new Animal("Kangaroo", true, false), a -> a.isCanHop());
    }

    private static void print(Animal animal, CheckTrait trait){
        if(trait.test(animal)){
            System.out.println(animal);//toString of Animal gets Printed
        }
    }
}
