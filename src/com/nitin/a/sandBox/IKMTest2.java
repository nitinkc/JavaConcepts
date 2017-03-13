package com.nitin.a.sandBox;

/**
 * Created by nitin on Wed, 3/8/17 at 9:36 PM.
 */
public class IKMTest2 extends Sub {
    @Override
    public String value() {
        return "IKMTest";
    }
    public static void main(String[] args) {
        IKMTest2 testClass = new IKMTest2();
        boolean b = false;
        char i = 't';
        if (testClass instanceof IKMType) {
            System.out.println((b = false) ? ((Super) testClass).value() : b);
        } else {
            System.out.println((b = true) ? ((Sub) testClass).value() : i);
        }
    }
}
interface IKMType {
    String value();
}
class Super implements IKMType {
    @Override
    public String value() {
        return "Super";
    }
}
class Sub extends Super {
    @Override
    public String value() {
        return "Sub";
    }
}