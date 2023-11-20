package nitin.tests;

import java.util.stream.Stream;

public class T15Switch {

    public static void main(String[] args) {
        Stream.of(90,80,70,60)
                .map(T15Switch::grade)
                .forEach(System.out::println);

       Stream.of(90,80,70,60)
                .map(T15Switch::grade2)
                .forEach(System.out::println);
    }


    private static String grade(int score){
        String grade = "";

        switch (Math.min(score/10, 10)){
            case 9,10: grade = "A";
            case 8: grade = "B";
            case 7: grade = "C";
            case 6: grade = "D";
            default: grade = "F";
        }
        return grade;
    }

    private static String grade2(int score){
        String grade = switch (Math.min(score/10, 10)) {
            case 9,10 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };

        return grade;
    }
}
