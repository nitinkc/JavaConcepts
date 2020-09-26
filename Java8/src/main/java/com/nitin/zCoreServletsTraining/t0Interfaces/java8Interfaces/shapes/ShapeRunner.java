package com.nitin.zCoreServletsTraining.t0Interfaces.java8Interfaces.shapes;
/** Tests using mixed Shape types and the static sumAreas method.
 */

public class ShapeRunner {
  public static void main(String[] args) {
    Shape[] shapes = { new Circle(10),       // Area is about 314.159
                       new Rectangle(5, 10), // Area is 50
                       new Square(10) };     // Area is 100

    System.out.println("Sum of areas: " +
                       Shape.sumAreas(shapes));   
                                            // Area is about 464.159
  }
}