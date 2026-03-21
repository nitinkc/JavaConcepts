package nitin.a6oops.inheritance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Created by Nitin Chaurasia on 3/6/16 at 11:37 PM. */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    private int age;

    public void animalMethod() {
        System.out.println("Animal.animalMethod");
    }
}
