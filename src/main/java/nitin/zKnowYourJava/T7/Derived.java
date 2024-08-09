package nitin.zKnowYourJava.T7;

public class Derived extends Base {
    private final String value;

    public Derived(String value) {
        System.out.println("In Derived");
        this.value = value;
    }

    @Override
    public void check() {
        if (value.length() == 0) {
            throw new RuntimeException("Null Value");
        }
    }
}
