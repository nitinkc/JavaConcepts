package nitin.performance;

import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		//Thread.sleep(20000);//For JConsole to work properly
		System.out.println("starting the work...");
		Date start = new Date();
		PrimeNumbers primeNumbers = new PrimeNumbers();
		Integer max = Integer.parseInt("10000");
		List<Integer> integerList = primeNumbers.generateNumbers(max);
		Date end = new Date();
		System.out.println("Total Time = " + (end.getTime()-start.getTime()) + "ms");
	}
}