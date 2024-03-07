package nitin.performance;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class GarbageCollectionStats {

    public static final String unit = "MB";

    public static void main(String[] args) throws InterruptedException
    {
        Runtime runtime = Runtime.getRuntime();

        long bytesInMb =  (1024*1024);
        System.out.println("Available memory at start: " + runtime.freeMemory()/bytesInMb + unit);

        // let's create lots of objects....
        List<Customer> customers = new ArrayList<Customer>();

        for (int i=0; i<1000000; i++) {
            customers.add(new Customer("John"));
        }

        System.out.println("Available memory  when customers created: " + runtime.freeMemory()/bytesInMb + unit);

        customers = new ArrayList<>();

        System.out.println("Available memory  when customers no longer referenced: " + runtime.freeMemory()/bytesInMb + unit);

        Thread.sleep(1000);

        System.out.println("Available memory  1 second later: " + runtime.freeMemory()/bytesInMb + unit);

        System.gc();

        System.out.println("Available memory  after GC command post Java 11 Optimizations: " + runtime.freeMemory()/bytesInMb + unit);
    }
}

@Data
@AllArgsConstructor
class Customer {
    private String name;
}