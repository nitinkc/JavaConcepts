package nitin.multithreading.completableFutureBasics;

import nitin.multithreading.completableFutureBasics.service.DataFetchService;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

import static com.utilities.PerformanceUtility.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CThenCombineTest {

    DataFetchService dfs = new DataFetchService();
    CThenCombine cf = new CThenCombine(dfs);

    @Test
    public void thenCombineCF() {
        //Sequential Time : Should take over 2000 milli seconds adn there has been artificial delay introduced
        startTimer();
        System.out.println((dfs.firstNameService()+ " " +dfs.lastNameService()).toUpperCase());
        stopTimer();

        resetTimer();

        //when
        startTimer();
        //Async Task: Should take Max(task1, Task2), close to a little over 1000 milli seconds
        CompletableFuture<String> completableFuture = cf.fullNameService();
        stopTimer();//results are not returned yet

        //then
        resetTimer();
        startTimer();
        completableFuture
                .thenAccept(fullName -> {
                    assertEquals(fullName,"JOHN DOE");
                })
                .join();//so that results can be collected
        stopTimer();
    }

    @Test
    public void fullNameWithGreetingServiceTest() {
        startTimer();
        //when
        CompletableFuture<String> completableFuture = cf.fullNameWithGreetingService();

        //then
        completableFuture
                .thenAccept(fullNameWithGreetings -> {
                    assertEquals(fullNameWithGreetings,"HELLO!! JOHN DOE");
                })
                .join();//so that results can be collected
        stopTimer();
    }
}