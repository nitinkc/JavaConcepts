package nitin.garbageCollection;

/** Created by nitin on Thu, 3/9/17 at 9:26 PM. */
public class HeapSize {
    public static void main(String[] args) {
        System.out.println("CurrentJVMHeapSize:" + Runtime.getRuntime().totalMemory());
        System.out.println("MaximumJVMHeapSize:" + Runtime.getRuntime().maxMemory());
        Runtime.getRuntime().gc();

        System.out.println("FreeJVMHeapSize:" + Runtime.getRuntime().freeMemory());
    }
}
