package nitin.virtualThreads;

import com.utilities.MultiThreadUtility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class V5 {

    private static final int MAX_THREADS = 20;
    private static final String FILE_PATH = "src/main/resources/twitter-words.txt";

    public static void main(String[] args) throws InterruptedException {
        //var executorService = Executors.newFixedThreadPool(MAX_THREADS);
        var executorService = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < MAX_THREADS; i++) {
            var index = i;
            executorService.submit(() -> fetchFile(index,FILE_PATH));
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
    public static void fetchFile(int index, String path){
        try {
            System.out.println(index + " Before : " + Thread.currentThread());
            MultiThreadUtility.delay(5000);
            var count = Files.lines(Paths.get(path)).count();
            System.out.println(index + " After : " + Thread.currentThread() + " # Lines " + count);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
