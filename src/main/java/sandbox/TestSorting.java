package sandbox;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSorting {

    public static void main(String[] args) {

        List<Person> listOfPersons=new ArrayList<Person>();
        listOfPersons.add(new Person("O'Keane, Maron L."));
        listOfPersons.add(new Person("Shepherd, Berthold."));
        listOfPersons.add(new Person("O'Rear, Drisana A."));
        listOfPersons.add(new Person("O'Donnchada, Ania X."));
        listOfPersons.add(new Person("Schlotterbeck, Brady X."));

        /*listOfPersons.stream()
                .sorted(Comparator.comparing(Person::getPersontFullName,Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());*/

        //listOfPersons.sort(Comparator.comparing(Person::getPersontFullName,Comparator.nullsLast(Comparator.naturalOrder())));
        Collections.sort(listOfPersons, Comparator.comparing(Person::getPersontFullName,Comparator.nullsLast(Comparator.naturalOrder())));
        listOfPersons.stream().forEach(System.out::println);

    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Person {

    private String persontFullName; //Last ,First,Mid
}
