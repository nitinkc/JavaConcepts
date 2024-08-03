package nitin.performance.softLeaks;
public class CustomerRunner_JMH {
	
	public static void main(String[] args) throws InterruptedException {
		CustomerManager cm = new CustomerManager();
		Producer producerTask = new Producer(cm);
		Consumer consumerTask = new Consumer(cm);
		
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(producerTask);
			t.start();
		}

		Thread t = new Thread(consumerTask);// Consumer
		t.start();
		
		//main thread is now acting as the monitoring thread
		while (true) {
			Thread.sleep(5000);
			cm.howManyCustomers();
			System.out.println("Available memory: " + Runtime.getRuntime().freeMemory() / 1024 + "k");
		}
	}
}