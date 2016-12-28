package com.nitin.a1languageFundamentals;

/**
 * Created by Nitin C on 11/25/2015.
 */

abstract class X {
    public abstract void check();
}

class Y extends X{

    @Override
    public void check() {

    }
}
class MultipleClassInaFile {
    public static void main(String[] args) {
        X obj1 = new Y();
        Y obj2 = new Y();

        obj1.check();
        obj2.check();
    }
}
