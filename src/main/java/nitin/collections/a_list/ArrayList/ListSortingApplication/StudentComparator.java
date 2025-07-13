package nitin.collections.a_list.ArrayList.ListSortingApplication;

import java.util.Comparator;

/** Created by synergisticit on 2/26/2016. */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        if (s1.id > s2.id) return 1;
        else if (s1.id < s2.id) return -1;
        else return fNameComparator(s1, s2);
    }

    private int fNameComparator(Student s1, Student s2) {
        if (s1.fName.compareTo(s2.fName) > 1) return 1;
        else if (s1.fName.compareTo(s2.fName) < 1) return -1;
        else return 0;
    }
}
