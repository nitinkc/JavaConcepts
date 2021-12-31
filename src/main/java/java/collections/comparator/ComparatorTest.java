package java.collections.comparator;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by synergisticit on 2/26/2016.
 */
public class ComparatorTest {
    public static void main(String[] args) {
        Student s1 = new Student(4, "Lucy", "Taylor", "Jenkov Taylor");
        Student s2 = new Student(2, "Tracy", "Rajaei", "Bill Taylor");
        Student s3 = new Student(1, "Joe", "Kresman", "Andrew Taylor");
        Student s4 = new Student(4, "Lucy", "Green", "Taylor Zimmarman");

        //HashSet does not need COMPARATOR, but TREESET DOES
        Set<Student> studentSet = new TreeSet<Student>(new StudentComparator());

        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3);
        studentSet.add(s4);

        Iterator<Student> itr = studentSet.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
