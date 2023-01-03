package com.entity;


import java.util.*;

/**
 * @author Created by nichaurasia
 * Created on Tuesday, September/29/2020 at 10:04 PM
 */

public class SampleData {
    public static List<Employee> EMPLOYEES =
            Arrays.asList(
                    new Employee("Nalini", "Parekh", new Date("03/09/1989"), Ethnicity.ASIAN,
                            null, "Infosys", 65256.25, 'C', 5),
                    new Employee("Max", "Plank", new Date("12/15/1979"), Ethnicity.NORTHAMERICAN,
                            new Address("121 Crazy Street", null, "Sanford", "FL", "USA", 32771),
                            "Deloitte", 158965, 'A', 10),
                    new Employee("Lfg", "Ksdfewrt", new Date("02/11/1995"), Ethnicity.NORTHAMERICAN,
                            new Address("121 Crazy Street", null, "Sanford", "FL", "USA", 32771),
                            "TCS", 25478, 'C', 7),
                    new Employee("John", "Doe", new Date("12/15/1979"), Ethnicity.NORTHAMERICAN,
                            new Address("121 Crazy Street", null, "Sanford", "FL", "USA", 32771),
                            "Deloitte", 35698, 'C', 6),
                    new Employee("Android", "Apple", new Date("01/02/1990"), Ethnicity.NORTHAMERICAN,
                            new Address("121 Crazy Street", null, "Sanford", "FL", "USA", 32771),
                            "Deloitte", 78956, 'C', 6),
                    new Employee("Butter", "Chicken", new Date("03/01/1986"), Ethnicity.NORTHAMERICAN,
                            new Address("121 Crazy Street", null, "Sanford", "FL", "USA", 32771),
                            "Deloitte", 96856, 'B', 5)
            );
    public static List<Student> STUDENTS = Arrays.asList(
            new Student("Abbott", "Zimmerman",
                    new Date("01/01/1990"), Ethnicity.NORTHAMERICAN,
                    new Address("121 Crazy Street", null, "Sanford", "FL", "USA", 32771),
                    Long.valueOf(1100112233), StudentOf.ENGINEERING),
            new Student("Abraham", "Lincoln",
                    new Date("01/01/1985"), Ethnicity.NORTHAMERICAN,
                    new Address("121 Crazy Street", null, "Nashville", "TN", "USA", 37221),
                    Long.valueOf(1100123456), StudentOf.ENGINEERING),
            new Student("Nicholas", "D'Costa",
                    new Date("03/01/1978"), Ethnicity.SOUTHAMERICAN,
                    new Address("121 Crazy Street", null, "Mexico City", "MC", "Mexico", 123456),
                    Long.valueOf(1100985632), StudentOf.MEDICINE),
            new Student("Mohandas", "Gandhi",
                    new Date("05/11/1975"), Ethnicity.ASIAN,
                    new Address("121 Crazy Street", null, "Porbandar", "GJ", "India", 486001),
                    Long.valueOf(1025698745), StudentOf.LAW),
            new Student("Xi", "Xinpi",
                    new Date("01/12/1983"), Ethnicity.ASIAN,
                    new Address("121 Crazy Street", null, "Beijing", "MD", "China", 45875),
                    Long.valueOf(1125698745), StudentOf.SPORTS),
            new Student("Nelson", "Mandella",
                    new Date("01/01/1989"), Ethnicity.AFRICAN,
                    new Address("121 Crazy Street", null, "Johannesburg", "FT", "South Africa", 147852),
                    Long.valueOf(1002300568), StudentOf.NURSING),
            new Student("Abbott", "Zimmerman",
                    new Date("01/01/1990"), Ethnicity.SOUTHAMERICAN,
                    new Address("121 Crazy Street", null, "MAchu pichu", "MP", "Peru", 589652),
                    Long.valueOf(1100112233), StudentOf.ENGINEERING),
            new Student("Abbott", "Zimmerman",
                    new Date("01/01/1990"), Ethnicity.NORTHAMERICAN,
                    new Address("121 Crazy Street", null, "Seattle", "WA", "USA", 84258),
                    Long.valueOf(1100112233), StudentOf.ENGINEERING)
    );
    private static List<EmployeeSimple> SIMPLE_EMPLOYEES = Arrays.asList(
            new EmployeeSimple("John", 20, Double.valueOf("65000"), 'C', 5),
            new EmployeeSimple("Wayne", 20, Double.valueOf("65430"), 'C', 4),
            new EmployeeSimple("Dow", 30, Double.valueOf("74445"), 'B', 6),
            new EmployeeSimple("Jane", 35, Double.valueOf("76546"), 'B', 5),
            new EmployeeSimple("Don", 35, Double.valueOf("90000"), 'A', 10),
            new EmployeeSimple("Wayne", 45, Double.valueOf("65430"), 'C', 4),
            new EmployeeSimple("John", 23, Double.valueOf("75430"), 'B', 5),
            new EmployeeSimple("John", 32, Double.valueOf("85430"), 'C', 12),
            new EmployeeSimple(),//Testing for nulls
            new EmployeeSimple(null, 99, Double.valueOf("85430"), 'C', 12),
            new EmployeeSimple(null, 35, Double.valueOf("90000"), 'A', 10)

    );

    private SampleData() {
    } // Uninstantiatable class

    public static List<Employee> getEmployees() {
        return (EMPLOYEES);
    }

    public static List<Student> getStudents() {
        return (STUDENTS);
    }

    public static List<Integer> intCargo(int numberOfElements) {

        Random r = new Random(9999);
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            ret.add(r.nextInt());
        }
        return ret;
    }

    public static List<Integer> intCargoSequence(int start, int end) {
        List<Integer> ret = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            ret.add(i);
        }
        return ret;
    }

    public static List<EmployeeSimple> getSimpleEmployees() {
        return (SIMPLE_EMPLOYEES);
    }
}
