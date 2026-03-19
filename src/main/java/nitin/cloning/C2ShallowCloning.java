package nitin.cloning;

/**
 * Created by Nitin Chaurasia on 12/4/15 at 9:16 PM.
 *
 * <p>Shallow copy is a bit-wise copy of an object. A new object is created that has an exact
 * copy of the values in the original object. If any of the fields are referenced to other
 * objects, only the reference addresses are copied.
 *
 * <p>FOR MUTABLE OBJECTS any changes made to a mutable field in main will reflect in the clone.
 *
 * <p>FOR IMMUTABLE OBJECTS like String and Integer, deep cloning is not required.
 */
public class C2ShallowCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        MutableState state = new MutableState(16);
        ShallowCloneTarget original = new ShallowCloneTarget(100, "Nitin", state);
        ShallowCloneTarget clone = original.clone();

        System.out.println("Object References");
        System.out.println(original);
        System.out.println(clone);
        System.out.println("-----------------------");

        System.out.println("State references (same object for shallow clone)");
        System.out.println(System.identityHashCode(original.getState()));
        System.out.println(System.identityHashCode(clone.getState()));
        System.out.println("-----------------------");

        original.getState().setMutableVar(99);
        System.out.println("After mutating original state");
        System.out.println(original.getState().getMutableVar());
        System.out.println(clone.getState().getMutableVar());
        System.out.println("-----------------------");
    }
}
