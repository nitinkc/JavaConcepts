package nitin.performance;

import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		//Thread.sleep(20000);
		System.out.println("starting the work...");
		PrimeNumbers primeNumbers = new PrimeNumbers();
		Integer max = Integer.parseInt("10000");
		List<Integer> integerList = primeNumbers.generateNumbers(max);
		//System.out.println(integerList);
	}
}