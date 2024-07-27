package nitin.virtualThreads.callable;

import nitin.virtualThreads.Business;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static com.utilities.PerformanceUtility.startTimer;
import static com.utilities.PerformanceUtility.stopTimer;

public class RequestHandler implements Callable<String> {

	@Override
	public String call() throws Exception {
		//return sequentialCall();//1
		//return concurrentCallWithFutures();//2: with its own virtual thread, Imperative style
		//return concurrentCallFunctional();//2.1: functional style

		return concurrentCallCompletableFuture();
	}

	// runs the tasks concurrently using Virtual Threads and Completable Futures.
	private String concurrentCallCompletableFuture() {
		try (ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {
			// CompletableFuture for dbCall with enhanced error handling
			CompletableFuture<String> dbCallFuture = CompletableFuture
					.supplyAsync(() -> Business.blockingDbCall(2), service)
					.exceptionally(ex -> {
						System.err.println("Exception occurred in dbCall: " + ex.getMessage());
						return "Default dbCallResult (Exception)";
					});

			// CompletableFuture for getBrewer with error handling
			CompletableFuture<String> getBrewerFuture = CompletableFuture.supplyAsync(() -> Business.getBrewer(), service)
					.exceptionally(ex -> {
						System.err.println("Exception occurred in getBrewer: " + ex.getMessage());
						return "Default brewer (Exception)";
					});

			// CompletableFuture for getBeer with error handling
			CompletableFuture<String> getBeerFuture = CompletableFuture.supplyAsync(() -> Business.getBeer(), service)
					.exceptionally(ex -> {
						System.err.println("Exception occurred in getBeer: " + ex.getMessage());
						return "Default beer (Exception)";
					});


			// Combine results of all CompletableFuture
			String output = CompletableFuture.allOf(dbCallFuture, getBrewerFuture, getBeerFuture)
					.thenApplyAsync(voidResult -> {
						String result1 = dbCallFuture.join();
						String result2 = getBrewerFuture.join();
						String result3 = getBeerFuture.join();
						return STR."[\{result1},\{result2},\{result3}]";
					}, service)
					.join();

			System.out.println(output);
			return output;

		}
	}

	//runs the tasks concurrently using Virtual Threads and Futures.
	private String concurrentCallWithFutures() throws Exception {
		//Starting 2 tasks under one thread
		try (ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {
			
			long start = System.currentTimeMillis();
			//One virtual thread per task
			Future<String> dbFuture   = service.submit(() -> Business.blockingDbCall(2));
			Future<String> restFuture = service.submit(Business::getBeer);

			//The get() calls are blocking calls
			String result = String.format("[%s,%s,%s]", "concurrentCallWithFutures ::  ",dbFuture.get(), restFuture.get());
			
			System.out.println("time = " + (System.currentTimeMillis() - start) + " ms");
			System.out.println("concurrentCallWithFutures ::" + result);
			return result;
			
		}
	}

	// runs the tasks concurrently using Virtual Threads, Futures and functional style.
	private String concurrentCallFunctional() throws Exception {
		try (ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {

			String result = service.invokeAll(Arrays.asList(() -> Business.blockingDbCall(2), Business::getBeer))
					.stream()
					.map(f -> {
						try {
							return (String)f.get();
						}
						catch (Exception e) {
							return null;
						}
					})
					.collect(Collectors.joining(","));

			return "[" + result + "]";

		}
	}

	 //Request which is handled Sequentially using Virtual Threads.
	private String sequentialCall() throws Exception {
		long start = System.currentTimeMillis();
		
		String result1 = Business.getBrewer();
		String result2 = Business.getBeer();
		
		String result = String.format("[%s,%s]", result1, result2);
		
		long end = System.currentTimeMillis();
		System.out.println("time = " + (end - start));

		return result;
	}
}