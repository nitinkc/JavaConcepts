package com.nitin.a13multithreadingEnhancements.dThreadLocal;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class dInheritableThreadLocal {
    public static void main(String[] args) {
        ParentThread1 pt = new ParentThread1();
        pt.start();
    }


}
class ParentThread1 extends Thread{
    public static InheritableThreadLocal tl = new InheritableThreadLocal();
    public void run(){
        tl.set("Parent Thread Local");
        System.out.println("Parent Thread Local Value = " + tl.get());

        //Creating the Child Thread from Parent
        ChildThread ct = new ChildThread();
        ct.run();
    }
}

class ChildThread1 extends Thread {
    public void run() {
        System.out.println("Child Thread Local Value = " +
                ParentThread.tl.get());//Null - should be Parent Thread Local : REDO LAST VIDEO TOWARDS END
    }
}