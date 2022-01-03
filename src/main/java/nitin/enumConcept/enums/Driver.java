package nitin.enumConcept.enums;

/**
 * Created by Nitin C on 3/5/2016.
 */
public class Driver {
    public static void main(String[] args) {
        Season s = Season.SUMMER;//Calling the ENUM
        //Season temp = Season.Summer;// Illegal Argument Exception

        System.out.println(s); //summer
        System.out.println(s == Season.SUMMER); // true

        // Looping through the ENUM
        for (Season itr : Season.values()){
            System.out.println(itr.ordinal() + " --- " + itr.name());
        }
    }
}
