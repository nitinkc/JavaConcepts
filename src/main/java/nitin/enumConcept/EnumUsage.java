package nitin.enumConcept;

/** Created by nitin on Saturday, October/12/2019 at 10:04 PM */
public class EnumUsage {
    public static void main(String[] args) {
        EnumDemo level = EnumDemo.SUNDAY;

        System.out.println(level.getLevelCode());
        System.out.println(level);
    }
}
