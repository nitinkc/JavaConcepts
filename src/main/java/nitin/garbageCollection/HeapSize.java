package nitin.garbageCollection;

import java.util.concurrent.ForkJoinPool;

/** Created by nitin on Thu, 3/9/17 at 9:26 PM. */
public class HeapSize {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("CurrentJVMHeapSize:" + runtime.totalMemory());
        System.out.println("MaximumJVMHeapSize:" + runtime.maxMemory());
        runtime.gc();

        System.out.println("FreeJVMHeapSize:" + runtime.freeMemory());

        System.out.println("Available Processors : " + runtime.availableProcessors());
        System.out.println("Total Memory : " + runtime.totalMemory());
        System.out.println("Fork Join Pool : " + ForkJoinPool.commonPool());
    }
}
