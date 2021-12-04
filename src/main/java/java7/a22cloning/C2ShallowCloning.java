package java7.a22cloning;

/**
 * Created by Nitin Chaurasia on 12/4/15 at 9:16 PM.
 *
 * Shallow copy is a bit-wise copy of an object.
 * A new object is created that has an exact copy of the values in the original object.
 * If any of the fields of the object are references to other objects,
 * just the reference addresses are copied i.e., only the memory address is copied.
 *
 * FOR MUTABLE OBJECTS
 * any changes made to object in main will reflect in clone.
 *
 * FOR IMMUTABLE OBJECTS like String Integer
 * Since the state cannot be changed, it doesnt need be deeply cloned
 *
 * Sharing the reference
 */
public class C2ShallowCloning {
    public static void main(String[] args) throws CloneNotSupportedException {

        // Creatinmg an object and creating its two clones
        X x1 = new X(100,"Nitin");
        X x2 = (X) x1.clone();
        X x3 = (X) x1.clone();

        // Printing the references of the clones and seeing if they all point to the same object
        System.out.println("Object References");
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x2);
        System.out.println("-----------------------");

        System.out.println(x1.getY());
        System.out.println(x2.getY());
        System.out.println(x3.getY());
        System.out.println("-----------------------");

        System.out.println("getY() +");
        System.out.println(x1.getY().var);
        System.out.println(x2.getY().var);
        System.out.println("-----------------------");
    }
}

class X implements Cloneable {
    private int a;
    private String b;
    //For Shallow Cloning
    private Y y;

    //Constructor
    X(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }

    /**
     * To use the clone method, you must override in your subclass and upgrade visibility to public
     * (overriding says one can increase its visiblity)
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        X x = (X) super.clone();
        x.setY(new Y(16));
        //return super.clone();
        return x;
    }
}
     class Y {
    int var;

    Y(int y) {
        var = y;
    }
}