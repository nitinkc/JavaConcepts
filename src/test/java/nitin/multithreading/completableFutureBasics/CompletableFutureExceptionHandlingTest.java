package nitin.multithreading.completableFutureBasics;

import nitin.streams.completableFutureBasics.CompletableFutureExceptionHandling;
import nitin.streams.completableFutureBasics.service.DataFetchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CompletableFutureExceptionHandlingTest {

    @Mock
    DataFetchService dataFetchService = new DataFetchService();

    @InjectMocks
    CompletableFutureExceptionHandling completableFutureExceptionHandling;

    @Test
    public void async_call_exception_handle_test_1exception() {

        //Given
        when(dataFetchService.greetingsService()).thenThrow(new NullPointerException("Exception"));//One Exception
        when((dataFetchService.firstNameService())).thenCallRealMethod();
        when((dataFetchService.lastNameService())).thenCallRealMethod();

        //When
        String result = completableFutureExceptionHandling.async_call_exception_handle();

        //then
        assertEquals(result, "ERROR HI!! JOHN DOE");
    }

    @Test
    public void async_call_exception_handle_test_2Exception() {

        //Given
        when(dataFetchService.greetingsService()).thenThrow(new NullPointerException("Exception"));
        when((dataFetchService.firstNameService())).thenThrow(new NullPointerException("Exception"));
        when((dataFetchService.lastNameService())).thenCallRealMethod();

        //When
        String result = completableFutureExceptionHandling.async_call_exception_handle();

        //then
        assertEquals(result, "ERROR FN!! DOE");
    }

    @Test
    public void async_call_exception_handle_test_no_exception() {

        //Given
        when(dataFetchService.greetingsService()).thenCallRealMethod();
        when((dataFetchService.firstNameService())).thenCallRealMethod();
        when((dataFetchService.lastNameService())).thenCallRealMethod();

        //When
        String result = completableFutureExceptionHandling.async_call_exception_handle();

        //then
        assertEquals(result, "HELLO!! JOHN DOE");
    }

    @Test
    public void async_call_exception_exceptionally_test_no_exception() {

        //Given
        when(dataFetchService.greetingsService()).thenCallRealMethod();
        when((dataFetchService.firstNameService())).thenCallRealMethod();
        when((dataFetchService.lastNameService())).thenCallRealMethod();

        //When
        String result = completableFutureExceptionHandling.async_call_exception_exceptionally();

        //then
        assertEquals(result, "HELLO!! JOHN DOE");
    }

    @Test
    public void async_call_exception_exceptionally_test_1_exception() {

        //Given
        when(dataFetchService.greetingsService()).thenThrow(new NullPointerException("Exception"));
        when((dataFetchService.firstNameService())).thenCallRealMethod();
        when((dataFetchService.lastNameService())).thenCallRealMethod();

        //When
        String result = completableFutureExceptionHandling.async_call_exception_handle();

        //then
        assertEquals(result, "ERROR HI!! JOHN DOE");
    }

    @Test
    public void async_call_exception_exceptionally_test_2_exception() {

        //Given
        when(dataFetchService.greetingsService()).thenThrow(new NullPointerException("Exception"));
        when((dataFetchService.firstNameService())).thenThrow(new NullPointerException("Exception"));
        when((dataFetchService.lastNameService())).thenCallRealMethod();

        //When
        String result = completableFutureExceptionHandling.async_call_exception_exceptionally();

        //then
        assertEquals(result, "ERROR FN!! DOE");
    }
}