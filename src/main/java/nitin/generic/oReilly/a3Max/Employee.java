package nitin.generic.oReilly.a3Max;

public class Employee {

    // Provide a default value for the orElse method
    public static final Employee DEFAULT_EMPLOYEE = new Employee(0, "No Name");

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id = " + id + " name = " + name;
    }
}
