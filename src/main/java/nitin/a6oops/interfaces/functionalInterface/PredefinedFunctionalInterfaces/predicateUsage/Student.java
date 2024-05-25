package nitin.a6oops.interfaces.functionalInterface.PredefinedFunctionalInterfaces.predicateUsage;

import java.util.List;

/**
 * Created by synergisticit on 2/25/2016.
 */
public class Student {
    int id;
    String fName;
    String lName;
    String fathersFullName;
    String deptCode;
    short sem;
    List<String> subjects;

    public Student(int id, String fName, String lName, String fathersFullName, String deptCode, short sem, List<String> subjects) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.fathersFullName = fathersFullName;
        this.deptCode = deptCode;
        this.sem = sem;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", fathersFullName='" + fathersFullName + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", sem=" + sem +
                ", subjects=" + subjects +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getFathersFullName() {
        return fathersFullName;
    }

    public void setFathersFullName(String fathersFullName) {
        this.fathersFullName = fathersFullName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public short getSem() {
        return sem;
    }

    public void setSem(short sem) {
        this.sem = sem;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}