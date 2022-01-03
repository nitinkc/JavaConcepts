package nitin.Strings;

/**
 * Created by nitin on Thu, 12/29/16 at 2:49 AM.
 */
public class S2StringMethods {
    public static void main(String[] args) {
        String x = "Malgudi Days by R.K Narayan Features malgudi";

        System.out.println(x.length());// length method
        System.out.println(x.charAt(9));

        // Index Of
        System.out.println(x.indexOf('M'));
        System.out.println(x.indexOf('a',3));
        System.out.println(x.indexOf("Days"));
        System.out.println(x.indexOf("gudi", 4));

        // Sub string

        //toLowerCase() , toUpperCase()

        // equals() , equalsIgnoreCase()

        // startesWith, endsWith

        //contains

        //replace

        // trim


    }
}
