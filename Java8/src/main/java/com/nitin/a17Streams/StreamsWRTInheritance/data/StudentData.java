package com.nitin.a17Streams.StreamsWRTInheritance.data;

import com.nitin.a17Streams.StreamsWRTInheritance.Address;
import com.nitin.a17Streams.StreamsWRTInheritance.Ethnicity;
import com.nitin.a17Streams.StreamsWRTInheritance.Student;
import com.nitin.a17Streams.StreamsWRTInheritance.StudentOf;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, September/29/2020 at 7:40 PM
 */

public class StudentData {
    public static List<Student> createStudent(){
        return Arrays.asList(
                new Student("Abbott","Zimmerman",
                        new Date("01/01/1990"), Ethnicity.NORTHAMERICAN,
                        new Address("121 Crazy Street", null, "Sanford", "FL", "USA", 32771),
                        Long.valueOf(1100112233), StudentOf.ENGINEERING),
                new Student("Abraham","Lincoln",
                        new Date("01/01/1985"), Ethnicity.NORTHAMERICAN,
                        new Address("121 Crazy Street", null, "Nashville", "TN", "USA", 37221),
                        Long.valueOf(1100123456), StudentOf.ENGINEERING),
                new Student("Nicholas","D'Costa",
                        new Date("03/01/1978"), Ethnicity.SOUTHAMERICAN,
                        new Address("121 Crazy Street", null, "Mexico City", "MC", "Mexico", 123456),
                        Long.valueOf(1100985632), StudentOf.MEDICINE),
                new Student("Mohandas","Gandhi",
                        new Date("05/11/1975"), Ethnicity.ASIAN,
                        new Address("121 Crazy Street", null, "Porbandar", "GJ", "India", 486001),
                        Long.valueOf(1025698745), StudentOf.LAW),
                new Student("Xi","Xinpi",
                        new Date("01/12/1983"), Ethnicity.ASIAN,
                        new Address("121 Crazy Street", null, "Beijing", "MD", "China", 45875),
                        Long.valueOf(1125698745), StudentOf.SPORTS),
                new Student("Nelson","Mandella",
                        new Date("01/01/1989"), Ethnicity.AFRICAN,
                        new Address("121 Crazy Street", null, "Johannesburg", "FT", "South Africa", 147852),
                        Long.valueOf(1002300568), StudentOf.NURSING),
                new Student("Abbott","Zimmerman",
                        new Date("01/01/1990"), Ethnicity.SOUTHAMERICAN,
                        new Address("121 Crazy Street", null, "MAchu pichu", "MP", "Peru", 589652),
                        Long.valueOf(1100112233), StudentOf.ENGINEERING),
                new Student("Abbott","Zimmerman",
                        new Date("01/01/1990"), Ethnicity.NORTHAMERICAN,
                        new Address("121 Crazy Street", null, "Seattle", "WA", "USA", 84258),
                        Long.valueOf(1100112233), StudentOf.ENGINEERING)
                );
    }
}
