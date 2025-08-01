package nitin.collections.d_maps.HashMap;

import java.util.HashMap;
import java.util.Map;

enum Pets {
    CATS,
    DOGS,
    HORSES
}

public class HashMapEg {
    public static void main(String[] args) {
        Map<Object, Object> m = new HashMap<Object, Object>();

        // Putting some RANDOM KEY and  VALUE

        m.put("1998", new Dog("Tuffy")); // 1998 IS THE kEY
        Dog d1 = new Dog("kalloo");
        m.put(d1, "Dog Key 1992"); // a5object d1 is used as a key
        m.put("k2", Pets.DOGS); // ENUM as Value
        m.put(Pets.CATS, "CAT Key");
        m.put(new Cat(), "Key value");

        System.out.println(m.get("1998")); // dOG OBJECT -->THE VALUE WILL VARY
        System.out.println(m.get(d1)); // a5object d1 is used as a key
        System.out.println(m.get("k2")); // Getting enum VALUE
        System.out.println(m.get(Pets.CATS)); // GETTING STRINGS on enum as a KEY -->enums override
        // equals() and hashCode().
        System.out.println(
                m.get(new Cat())); // the get() method failed to find the Cat a5object that was
        // inserted earlier.It's easy to see that Dog overrode equals()
        // and hashCode() while Cat didn't.
        System.out.println(m.size());
    }
}

class Cat {}

class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        return (o instanceof Dog) && (((Dog) o).name == this.name);
    }

    public int HashCode() {
        return name.length();
    }
}
