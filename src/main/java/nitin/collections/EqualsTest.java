package nitin.collections;

public class EqualsTest {
    public static void main(String[] arg) {

        Integer i = Integer.valueOf(3);
        Integer j = Integer.valueOf(3);

        if (i == j) //2 different objects
            System.out.println("true");
        else
            System.out.println("false");

        if (i.equals(j)) //2 different objects
            System.out.println("true");
        else
            System.out.println("false");
    }
}