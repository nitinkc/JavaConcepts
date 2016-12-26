package com.nitin.multithreadingEnhancements.dThreadLocal;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class cThreadLocalNInheritance {
    public static void main(String[] args) {
        ParentThread pt = new ParentThread();
        pt.start();
    }
}

class ParentThread extends Thread{
    public static ThreadLocal tl = new ThreadLocal();
    public void run(){
        tl.set("Parent Thread Local");
        System.out.println("Parent Thread Local Value = " + tl.get());

        //Creating the Child Thread from Parent
        ChildThread ct = new ChildThread();
        ct.run();
    }
}

class ChildThread extends Thread {
    public void run(){
        System.out.println("Child Thread Local Value = " +
                ParentThread.tl.get());//Parent Thread Local - should be null : REDO LAST VIDEO TOWARDS END
    }
}
