package nitin.calandarDateTime.jodaTime;

import com.utilities.OldDateUtilities;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/** Created by nichaurasia on Wednesday, May/06/2020 at 5:54 PM */
public class NFridays {
    public static void main(String[] args) {
        DateTimeFormatter dateFormat = DateTimeFormat.forPattern("E,d Y");
        // .forPattern("G,C,Y,x,w,e,E,Y,D,M,d,a,K,h,H,k,m,s,S,z,Z");

        List<DateTime> list = OldDateUtilities.findLastNFridaysJodaTime(5);

        if (list != null) {
            for (DateTime d : list) {
                // System.out.println(dateFormat.print(d));
                System.out.println(d.toString(DateTimeFormat.fullDateTime()));
            }
        }
    }
}
