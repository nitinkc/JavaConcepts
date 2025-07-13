package nitin.a5object;

/** Created by nitin.chaurasia on 3/3/2017. */
public class O3UsingClass4Name {
    public static void main(String[] args) {

        try {

            Class s = Class.forName("java.a5object.Sample");
            Sample obj = (Sample) s.newInstance();
            System.out.println(obj.hashcode());

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
