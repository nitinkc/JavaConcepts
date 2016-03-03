package com.nitin.java8.OCJP;

/**
 * Created by Nitin Chaurasia on 3/3/16 at 12:26 AM.
 */
public class FindMatchingAnimals {

    public static void main(String[] args) {
        print(new Animal("fish",false, true), a -> a.isCanHop());
        print(new Animal("kangaroo", true, false), a -> a.isCanHop());

    }
    public static void print(Animal animal, CheckTrait trait){
        if (trait.test(animal)){
            System.out.println(animal);
        }
    }
}
