package nitin.oops.interfaces;

/**
 * Created by nitin on 12/29/16.
 */
public class I4AdapterClass extends AdapterX {

    public static void main(String[] args) {
        I4AdapterClass obj = new I4AdapterClass();
        obj.m2();
        obj.m3();
    }

    @Override
    public void m3(){
        System.out.println("Providing Implementation of only M3, even though we have access to all the methods, " +
                "we can choose to implement what we like in Adapter pattern");

    }

    @Override
    public void m2(){
        System.out.println("Implementation if m2");
    }
}


interface X{
    void m1();
    void m2();
    void m3();
    void m4();
    void m5();
}


// Providing empty implementation
 abstract class AdapterX implements X{

     @Override
     public void m1() {

     }

     @Override
     public void m2() {

     }

     @Override
     public void m3() {

     }

     @Override
     public void m4() {

     }

     @Override
     public void m5() {

     }
 }