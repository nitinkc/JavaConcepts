package java.javaMemoryModel;

public class AllObjectsCreatedInTheHeap {
    public static void main(String[] args) {
        int a = 0; // All local variables Created in the Stack

        //Objects are Stored in the Heap Area. The reference to the variable is stored in the stack
        String str = "Nitin";

    }
}
