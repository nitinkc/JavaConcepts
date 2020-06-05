package com.nitin.a9generics.oReilly.a0raw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitin C on 3/4/2016.
 */
public class C1TypedAutoBoxingNUnboxing {
    public static void main(String[] args) {
        //Generics do not accept primitive types
        //Java does the auto boxing and unboxing

        List<Integer> intsList = new ArrayList<>();
        intsList.add(3);//Adding primitive
        intsList.add(new Integer(4));//Unnecessasary Boxing

        int x = intsList.get(0);
        int y = intsList.get(1);//Auto unboxing performed and assigned to a primitive
    }

}
