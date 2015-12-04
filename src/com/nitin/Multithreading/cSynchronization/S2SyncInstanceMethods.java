package com.nitin.multithreading.cSynchronization;

import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;

/**
 * Created by Nitin Chaurasia on 12/3/15 at 6:02 AM.
 */
public class S2SyncInstanceMethods {




}

class Counter{
    // this method is synchronized. Only one thread is allowed access at a time
    int count = 0;
    public synchronized void add(int value){
        count += value;
    }
}

class CounterThread implements Runnable{
    @Override
    public void run() {
        Counter c = new Counter();


    }
}
