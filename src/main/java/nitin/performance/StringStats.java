package nitin.performance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StringStats {
    //Pick up a prime number for the string table size
    //Run with -XX:+PrintStringTableStatistics -XX:StringTableSize=120121 -Xms1g -Xmx4g
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Date start = new Date();
        for (Integer i = 0; i < 10_000_000; i++) {
             list.add(i.toString().intern());//Faker.instance().name().fullName()
        }
        Date end = new Date();
        System.out.println("Time Taken : " + (end.getTime()- start.getTime()) + " ms");
    }
}
