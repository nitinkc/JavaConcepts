package nitin.a6oops.inheritance;

/** Created by Nitin Chaurasia on 3/6/16 at 11:37 PM. */
public class Animal {
    private int age;

    public Animal(int age) {}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Lion extends Animal {

    public Lion(int age) {
        super(age);
    }
}
