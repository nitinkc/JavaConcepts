package java.a1languageFundamentals;

class A {

    public void music() {
        System.out.println(" this is from music ");
    }

    /* Method overloading */
    int music(int disk) {
        System.out.println(" this is from overloaded music : disk = " + disk);
        return disk;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        A obj = new A();
        obj.music();
        obj.music(2);
    }

}
