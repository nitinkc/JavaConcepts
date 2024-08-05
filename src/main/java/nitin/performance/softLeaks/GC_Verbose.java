package nitin.performance.softLeaks;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class GC_Verbose {

	public static void main(String[] args) throws InterruptedException {
		//Run with -Xmx5m -verbose:gc
		int size = 10000;
		List<Customer> customers = new ArrayList<Customer>();
		while(true) {
			Customer c = new Customer(Faker.instance().harryPotter().character());
			customers.add(c);
			if (customers.size() > size)
				for (int i = 0; i < size/2; i++)
					customers.remove(0);//simulating the conditions to run GC
			
			//Thread.sleep(10);
		}

	}

}
