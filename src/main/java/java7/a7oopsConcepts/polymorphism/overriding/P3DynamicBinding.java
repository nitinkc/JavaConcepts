package java7.a7oopsConcepts.polymorphism.overriding;

/**
 * Created by Nitin Chaurasia on 2/1/18 at 4:45 PM.
 */
public class P3DynamicBinding{
    public static void main(String[] args) {
        Parent p = new Child();

        p.m1();// dynamic binding, at run time, it invokes childs m1()
    }
}

class Parent{
    public void m1(){
        System.out.println("From Parent");
    }
}

class Child extends Parent{
    public void m1(){
        System.out.println("From Child");
    }
}