package nitin.streams.parallelStreams;

import java.util.concurrent.ForkJoinPool;

public class ThreadsStats {
    public static void main(String[] args) {
        System.out.println("Available Processors : " + Runtime.getRuntime().availableProcessors());
        System.out.println("Total Memory : " + Runtime.getRuntime().totalMemory());
        System.out.println("Fork Join Pool : " + ForkJoinPool.commonPool());
    }
}
