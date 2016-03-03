package ArrayList.ListSearchingApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by synergisticit on 2/26/2016.
 */
public class ListSearchDriver {
    public static void main(String[] args) {
        Student s1 = new Student(4,"Lucy","Taylor","Jenkov Taylor");
        Student s2 = new Student(2,"Tracy","Rajaei","Bill Taylor");
        Student s3 = new Student(1,"Joe","Kresman","Andrew Taylor");
        Student s4 = new Student(4,"Lucy","Green","Taylor Zimmarman");

        List<Student> students = new ArrayList<Student>();
        students.add(s1);students.add(s2);
        students.add(s3);students.add(s4);

        Student s5 = new Student(4,"Lucy","Green","Taylor Zimmarman");


        System.out.println(students.contains(s5));
        System.out.println(students.get(0).equals(students.get(1)));
        System.out.println(students.get(3));
    }

}
