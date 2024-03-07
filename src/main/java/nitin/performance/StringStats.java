package nitin.performance;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StringStats {
    //Run with -XX:+PrintStringTableStatistics -XX:StringTableSize=999999 -Xmx1g -Xms4g
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Date start = new Date();
        for (Integer i = 0; i < 10000000; i++) {
             list.add(i.toString().intern());//Faker.instance().name().fullName()
        }
        Date end = new Date();
        System.out.println("Time Taken : " + (end.getTime()- start.getTime()) + " ms");
    }
}
