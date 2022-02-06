package nitin.javaMemoryModel;

/**
 * Created by Nitin Chaurasia on 12/29/16 at 12:51 AM.
 * Final is applicable for classes, methods and variables
 */
public class ChangeFinal {
    public static void main(String[] args) {

        final Customer c = new Customer("Mahatma Gandhi");
        System.out.println("Final String is : " + c);

        // CHANGING THE FINAL variable, as the String lies in the Heap area. The c variable on the Stack is Final not
        // not the String on the heap;
        c.setName("Modi");
        System.out.println("Final String is reset to : " + c);
    }

    static class Customer {
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

        @Override
        public String toString() {
            return this.getName();
        }
    }

}
