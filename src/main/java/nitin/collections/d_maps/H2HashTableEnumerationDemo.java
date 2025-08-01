package nitin.collections.d_maps;

import java.util.Enumeration;
import java.util.Hashtable;

public class H2HashTableEnumerationDemo {

    public static void main(String[] args) {
        // Create a hash map
        Hashtable<String, Double> balance = new Hashtable<>();
        // Enumeration names;
        // Iterator<String> itr = (Iterator<String>) balance.;
        String str;
        double bal;

        balance.put("Zara", Double.valueOf("3434.34"));
        balance.put("Mahnaz", Double.valueOf(123.22));
        balance.put("Ayan", Double.valueOf(1378.00));
        balance.put("Daisy", Double.valueOf(99.22));
        balance.put("Qadir", Double.valueOf(-19.08));

        // Show all balances in hash table.
        Enumeration<String> names = balance.keys();
        while (names.hasMoreElements()) {
            str = names.nextElement();
            System.out.println(str + ": " + balance.get(str));
        }
        System.out.println();
        // Deposit 1,000 into Zara's account
        bal = balance.get("Zara").doubleValue();
        balance.put("Zara", Double.valueOf(bal + 1000));
        System.out.println("Zara's new balance: " + balance.get("Zara"));
    }
}
