package nitin.multithreading.aBasics;

/**
 * Created by Nitin Chaurasia on 12/2/15 at 10:55 PM.
 */
public class T5NameCustomization {
    public static void main(String[] args) {

        Thread t = Thread.currentThread();

        //There is Always a main Thread
        System.out.println(t);// Main Thread
        /* Thread[Nitin,5,main]
         *  Thread Name, PRIORITY = 5, by Default for main, Method executing the thread
         * */


        //Name Customization
        Thread.currentThread().setName("Nitin");
        System.out.println(t);

        //Individual Tupples
        System.out.println(t.getName());
        System.out.println(t.getId());
        System.out.println(t.getPriority());
        //Check the State of the Thread.
        System.out.println(t.getState());

        //Variables
        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);

    }
}


