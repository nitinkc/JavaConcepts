package com.nitin.a8designPatternsNPrinciples.Structural.S1Decorator.shapes;

public class Circle extends ShapeDecorator{
    double radius;
    public Circle(double radius){
        super();
        this.radius = radius;
    }
    @Override
    public String draw() {
        String ret = "Drawing Circle of Radius : " + radius;
        System.out.println(ret);
        return  ret;
    }
}
