package sandbox;

/**
 * Created by nitin on Sunday, October/13/2019 at 8:00 PM
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        List<Shape> list = new ArrayList<>();

        list.add(new Circle());
        list.add(new Line());

        for(Shape s : list){
            System.out.print(s.draw("text output"));
        }
    }
}

abstract class Shape{
    public char draw(String str){
        System.out.print("");
        return ' ';
    }

    //more draw methods to have DirectX or OpenGL as parameters
}

class Circle extends Shape {
    //Constructor
    public Circle(){}
    //Over riding method
    public char draw(String str){
        //System.out.print("c");
        return 'c';
    }

}

class Line extends Shape{
    //Constructor
    public Line(){}

    //Over ridden method for Line Class object
    public char draw(String str){
        //System.out.print("l");
        return 'l';
    }
}


