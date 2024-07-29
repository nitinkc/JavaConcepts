package nitin.multithreading.bFuturesAndCompletableFutures;

import org.springframework.scheduling.annotation.Async;

public class TestAsync {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            asyncMethodWithVoidReturnType(i);

        }
    }

    @Async
    public static void asyncMethodWithVoidReturnType(int i) {
        System.out.println("Execute method asynchronously. #" + i
                + " :: " + Thread.currentThread().getName());
    }
}
