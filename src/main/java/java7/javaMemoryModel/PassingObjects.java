package java7.javaMemoryModel;

/**
 * Created by nitin.chaurasia on 2/16/2017.
 * For objects passed into methods, the REFERENCE to the object as passed BY VALUE
 */
public class PassingObjects {
    public static void main(String[] args) {
        Customer c = new Customer("Nitin");

        // Reference to the object c is passed bu value here,
        renameCustomer(c);

        System.out.println(c.getName());

    }

    // Reference to the object c is passed bu value here, both pointing to the same string
    private static void renameCustomer(Customer c) {
        c.setName("Chaurasia");
    }
}

class Customer{
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
