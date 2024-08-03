package nitin.performance.softLeaks;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class Producer implements Runnable {
	private CustomerManager cm;

	@Override
	public void run() {
		while (true) {
			try {
				//This is just to slow things down so we can see what's going on!
				Thread.sleep(2);
			} catch (InterruptedException e) {
			}
			String name = UUID.randomUUID().toString();
			Customer c = new Customer(name);
			cm.addCustomer(c);
		}
	}
}



