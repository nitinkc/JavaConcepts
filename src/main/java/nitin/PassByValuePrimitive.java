package nitin;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;

public class PassByValuePrimitive {
    public static void main(String[] args) {
        int a = 10;//All nums are primitive
        modifyPrimitive(a);
        System.out.println(a);

        /*
        the Integer.String, Double, BigDecimal class is immutable, meaning its value cannot be changed once it is assigned.
        Therefore, when you pass an Integer object to a method and modify it inside the method,
        you're actually creating a new Integer object with the modified value.
        */
        Integer b = 10;
        modifyObject(b);
        System.out.println(b);

        final Customer c = new Customer("John");//Final variable's reference can't be changed, the values inside the object can change
        System.out.println(c);//Customer(name=John)
        modifyObject2(c);
        System.out.println(c);//Customer(name=Jane)

        Faker.instance().name().fullName();
    }

    private static void modifyObject2(Customer cust) {
        cust.setName("Jane");
    }

    private static void modifyObject(Integer data) {
        Integer temp = data + 2;
        data = temp * 2;// Creating a new Integer object and assigning it to data
    }

    private static void modifyPrimitive(int data) {
        int temp = data + 2;
        data = temp * 2;
    }
}

@Data
@AllArgsConstructor
class Customer{
    String name;
}
