package ArrayList.ListSortingApplication;

/**
 * Created by synergisticit on 2/25/2016.
 */
public class Student {
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
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", fathersFullName='" + fathersFullName + '\'' +
                '}';
    }
}