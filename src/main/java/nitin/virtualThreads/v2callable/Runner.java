package nitin.virtualThreads.v2callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * A thread is assigned to each user and the thread calls the RequestHandler
 * which in-turn invokes calls to database,REST api, file handling calls which are all blocking calls.
 */
public class Runner {
	private static final int NUM_USERS = 1;//1_000_000;

	public static void main(String[] args) {
		//Creating virtual thread per taskExecutor via factory
		ThreadFactory factory =  Thread.ofVirtual().name("request-handler-",0).factory();
		//ThreadFactory ptFactory =  Thread.ofPlatform().name("request-handler-pt-",0).factory();
		try (ExecutorService executor = Executors.newThreadPerTaskExecutor(factory)) {//One thread per user if ptFactory is used
			for (int i = 0; i < NUM_USERS; i++) {
				//Submit needs a callable task
				executor.submit(new RequestHandler());//Controls the style from the constructor of RequestHandler
			}
		}
	}
}
