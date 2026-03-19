package nitin.cloning;

/** Created by Nitin Chaurasia on 12/7/15 at 11:56 AM. */
public class C3DeepCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        MutableState state = new MutableState(16);
        DeepCloneTarget original = new DeepCloneTarget(100, "Nitin", state);
        DeepCloneTarget clone = original.clone();

        System.out.println("Object References");
        System.out.println(original);
        System.out.println(clone);
        System.out.println("-----------------------");

        System.out.println("State references (different objects for deep clone)");
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
