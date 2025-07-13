package nitin.exceptionHandling;

/** Created by nitin on Wednesday, September/25/2019 at 8:06 PM */
public class NestedException {
    public static void main(String[] args) {
        String s1 = "Nitin";
        String s2 = null;

        try {
            System.out.println("Beginning Try");

            try {
                System.out.println("Number Format");
                System.out.println(32 / 0);
            } catch (ArithmeticException e) {
                System.out.println("nested 1 : NUMBER FORMAT EXCEPTION : Outside Main try Block ");
                e.printStackTrace();
            }

            try {
                System.out.println("Null Pointer");
                s1.compareTo(s2);
            } catch (NullPointerException e) {
                System.out.println("nested 2 : NULL POINTER EXCEPTION : Outside Main try Block ");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION : Outside Main try Block ");
            e.printStackTrace();
        }
    }
}
