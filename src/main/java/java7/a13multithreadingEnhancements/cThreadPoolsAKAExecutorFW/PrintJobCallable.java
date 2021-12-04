package java7.a13multithreadingEnhancements.cThreadPoolsAKAExecutorFW;

import java.util.concurrent.Callable;

/**
 * Created by nitin.chaurasia on 12/26/2016.
 */
public class PrintJobCallable implements Callable {
    int num;
    PrintJobCallable(int num){
        this.num = num;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is responsible for adding first " + num +" numbers");

        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
