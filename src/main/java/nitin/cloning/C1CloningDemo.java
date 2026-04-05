package nitin.cloning;

/** Created by Nitin Chaurasia on 12/4/15 at 1:49 AM. */
public class C1CloningDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Stock obj = new Stock(560, " google");
        // Clone returns Object Type
        Stock cloned = (Stock) obj.clone();
        System.out.println("Original Object :: " + obj);
        System.out.println("Cloned Object :: " + cloned);

        System.out.println(obj.hashCode());
        System.out.println(cloned.hashCode());
    }
}
