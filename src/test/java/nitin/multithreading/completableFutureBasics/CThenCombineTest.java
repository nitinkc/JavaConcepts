package nitin.multithreading.completableFutureBasics;

import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.A12ThenCombine;
import nitin.multithreading.bFuturesAndCompletableFutures.completableFutureBasics.service.DataFetchService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CompletableFuture;

import static com.utilities.PerformanceUtility.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CThenCombineTest {

    DataFetchService dfs = new DataFetchService();
    A12ThenCombine cf = new A12ThenCombine();

    @Test
    public void thenCombineCF() {
        //Sequential Time : Should take over 2000 milli seconds adn there has been artificial delay introduced
        startTimer();
        System.out.println((dfs.firstNameService(3) + " " + dfs.lastNameService(1000)).toUpperCase());
        stopTimer();

        resetTimer();

        //when
        startTimer();
        //Async Task: Should take Max(task1, Task2), close to a little over 1000 milli seconds
        CompletableFuture<String> completableFuture = A12ThenCombine.fullNameService();
        stopTimer();//results are not returned yet

        //then
        resetTimer();
        startTimer();
        completableFuture
                .thenAccept(fullName -> {
                    assertEquals(fullName, "JOHN DOE");
                })
                .join();//so that results can be collected
        stopTimer();
    }

    @Test
    public void fullNameWithGreetingServiceTest() {
        startTimer();
        //when
        CompletableFuture<String> completableFuture = A12ThenCombine.fullNameWithGreetingService();

        //then
        completableFuture
                .thenAccept(fullNameWithGreetings -> {
                    assertEquals(fullNameWithGreetings, "HELLO!! JOHN DOE");
                })
                .join();//so that results can be collected
        stopTimer();
    }

    @Test
    public void fullNameWithGreetingAndGoodByesServiceTest() {
        startTimer();
        //when
        CompletableFuture<String> completableFuture = A12ThenCombine.fullNameWithGreetingAndGoodByesService();

        //then
        completableFuture
                .thenAccept(fullNameWithGreetings -> {
                    assertEquals(fullNameWithGreetings, "Hello!! john doe, Thank You!!");
                })
                .join();//so that results can be collected
        stopTimer();
    }
}