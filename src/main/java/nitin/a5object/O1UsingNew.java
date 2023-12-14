package nitin.a5object;

/**
 * Created by nitin.chaurasia on 3/3/2017.
 */
public class O1UsingNew {

    public static void main(String[] args) {

        Employee e = new Employee(1, "Nitin");
        Employee e1 = new Employee(2, "Chaurasia");
        e.display();
        e1.display();
    }
}

class Employee {
    private final int id;
    private final String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display() {

        System.out.println(id + " " + name);

    }
}