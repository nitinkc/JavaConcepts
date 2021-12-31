package java.streams.StreamsWRTInheritance.data;


import java.streams.StreamsWRTInheritance.Address;
import java.streams.StreamsWRTInheritance.Employee;
import java.streams.StreamsWRTInheritance.Ethnicity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, September/29/2020 at 10:04 PM
 */

public class EmployeeData {
    public static List<Employee> createStudent() {
        return Arrays.asList(
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
    }
}
