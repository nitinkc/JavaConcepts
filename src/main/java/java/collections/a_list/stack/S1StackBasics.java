package java.collections.a_list.stack;

import java.util.Stack;

/**
 * Created by nitin on Thu, 2/2/17 at 10:34 PM.
 */
public class S1StackBasics {
    public static void main(String[] args) {
//        List<Integer> stack = new Stack<>();//Only List methods are available
        Stack<Integer> stack = new Stack<>();
        //Push and add does the same thing
        stack.push(10);stack.push(15); stack.push(35);
        stack.add(11);stack.add(16); stack.add(36);
        stack.push(12);stack.push(17); stack.push(37);

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
