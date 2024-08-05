package nitin.multithreading.aBasics.aPlatformThreads;

/**
 * Created by Nitin Chaurasia on 12/2/15 at 9:29 PM.
 * <p>
 * Difference between t.start() and t.run()
 * t.start calls run() from within. if t.run is executed,
 * run method will execute normally.
 * <p>
 * ALSO. Since by extending, we are limiting to extending only one class.
 * NO CHANCE OF EXTENDING ANY OTHER CLASS!!
 * We cannot extend any other class. Thus implementing Runnable Interface
 * is preferred over this approach.
 */
public class T2ThreadByExtending {
    public static void main(String[] args) {
        //Instantiate the Thread
        ThreadDemo t = new ThreadDemo();

        // t.run() will be like normal method call.
        t.run(); // normal function call, thus run() will execute first

        // t.start will internally call run method.
        t.start(); //Make the thread run, Order of execution of threads, not guaranteed

        //DO NOT RESTART THE THREAD AGAIN
        t.start();// Throws IllegalThreadStateException
        // But Child thread continues execution

        // Calling the Overloaded run()
        // Acts like a normal method call
        t.run(25);


        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}

// Thread Scheduler Decides which thread runs First
// Undeterministic Response
class ThreadDemo extends Thread {

    // If run method is not overridden, it will execute like an empty implementation
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Child Thread: " + i);
        }
    }

    //OverLoading of Run is Possible, but start() will call run() without arguments
    //Overloaded run method will behave like a normal method

    public void run(int i) {
        System.out.println("From Overloaded Run" + i);
    }
}

