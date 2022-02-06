package nitin.collections.comparable;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by synergisticit on 2/25/2016
 * <p>
 * If we wish to insert Student object into TreeSet (which needs compare logic), we will get the following error
 * java.lang.ClassCastException if Student does not implement java.lang.Comparable
 * MNEMONIC BC (comparaBle - ClassCast)
 * <p>
 * Whenever we use Object other THAN WRAPPER
 * <p>
 * This problem CANNOT be solved with COMPARATOR.
 * comparator can be used when we call java Utility Class
 */
// a10collections.sort(List<Integer>, comparator<...>)
public class ComparableTestFailed {
    public static void main(String[] args) {
        Student s1 = new Student(4, "Lucy", "Taylor", "Jenkov Taylor");
        Student s2 = new Student(2, "Tracy", "Rajaei", "Bill Taylor");
        Student s3 = new Student(1, "Joe", "Kresman", "Andrew Taylor");
        Student s4 = new Student(4, "Lucy", "Green", "Taylor Zimmarman");

        //HashSet does not need COMPARATOR, but TREE DOES
        Set<Student> studentSet = new TreeSet<>();

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

class Student implements Comparable {
    int id;
    String fName;
    String lName;
    String fathersFullName;

    public Student(int id, String fName, String lName, String fathersFullName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.fathersFullName = fathersFullName;
    }

    @Override
    public int compareTo(Object o) {
        return compareFirstNames(o);
    }

    // Lexicographical Order
    private int compareFirstNames(Object o) {
        Student curr = (Student) o;
        int ret = this.fName.compareTo(curr.fName);
        if (ret != 0)
            return ret;
        else
            return compareFathersName(o);
    }

    private int compareFathersName(Object o) {
        Student curr = (Student) o;

        return this.fathersFullName.compareTo(curr.fathersFullName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", fathersFullName='" + fathersFullName + '\'' +
                '}';
    }
}