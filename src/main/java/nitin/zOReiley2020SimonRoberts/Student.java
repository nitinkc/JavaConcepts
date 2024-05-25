package nitin.zOReiley2020SimonRoberts;

import java.util.*;
import java.util.stream.Collectors;

public class Student {

    private static final NavigableMap<Integer, String> gradeLetters = new TreeMap<>();

    static {
        gradeLetters.put(90, "A");
        gradeLetters.put(80, "B");
        gradeLetters.put(70, "C");
        gradeLetters.put(60, "D");
        gradeLetters.put(50, "E");
        gradeLetters.put(0, "F");
    }

    private final String name;
    private final int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static void main(String[] args) {
        List<Student> school = Arrays.asList(
                new Student("Fred", 71),
                new Student("Jim", 38),
                new Student("Sheila", 97),
                new Student("Weatherwax", 100),
                new Student("Ogg", 56),
                new Student("Rincewind", 28),
                new Student("Ridcully", 65),
                new Student("Magrat", 79),
                new Student("Valentine", 93),
                new Student("Gillian", 87),
                new Student("Anne", 91),
                new Student("Dr. Mahmoud", 88),
                new Student("Ender", 91),
                new Student("Hyrum", 72),
                new Student("Locke", 91),
                new Student("Bonzo", 57));

//    school.forEach(s -> System.out.println(s));
        Map<String, Long> grades = school.stream()
                .collect(Collectors.groupingBy(s -> s.getLetterGrade(), Collectors.counting()));
//    grades.forEach((k,v) -> System.out.println(k + " achieved by: " + v));
        Comparator<Map.Entry<String, Long>> order = Map.Entry.comparingByValue();
        order = order.reversed();
        grades.entrySet().stream()
                .sorted(order)
                .forEach(e -> System.out.println(e.getValue() + " students achieved grade " + e.getKey()));
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getLetterGrade() {
        return gradeLetters.floorEntry(score).getValue();
    }

    @Override
    public String toString() {
        return name + ", " + score + "%";
    }
}
