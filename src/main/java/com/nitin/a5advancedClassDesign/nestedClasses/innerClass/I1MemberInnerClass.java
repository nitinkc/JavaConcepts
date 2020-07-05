package com.nitin.a5advancedClassDesign.nestedClasses.innerClass;

/**
 * Created by Nitin Chaurasia on 3/5/16 at 12:03 AM.
 */
public class I1MemberInnerClass {
    private final String name = "Nitin";

    protected class Inner{
        public int n = 3;
        public void m1(){
            for (int i = 0; i < 10; i++) {
                System.out.print(name + " : ");//Inner class have access to outer class field
            }
        }
    }

    // Demonstration of a private interface
    private interface PrivateInterface{
        void secretMethod();
    }

    //Have to instantiate Inner class to be of any use
    public void callInner(){
        Inner inner = new Inner();
        inner.m1();
    }

    public class ImplementPrivateInterface implements PrivateInterface{
        @Override
        public void secretMethod() {
            System.out.println("Implemented Secret method of private interface in an inner class");
        }
    }

    public static void main(String[] args) {
        I1MemberInnerClass i1MemberInnerClass = new I1MemberInnerClass();
        i1MemberInnerClass.callInner();

        System.out.println("\n@@@@@#@#@@@@@#@#@##@@");
        //Another way of Instantiating
        I1MemberInnerClass test = new I1MemberInnerClass();
        Inner inner = test.new Inner();
        inner.m1();

        System.out.println("\n@@@@@#@#@@@@@#@#@##@@");
        I1MemberInnerClass testPrivateInterface = new I1MemberInnerClass();
        ImplementPrivateInterface innerInterface = testPrivateInterface.new ImplementPrivateInterface();
        innerInterface.secretMethod();
    }
}
