package com.nitin.a8designPatternsNPrinciples.Structural.S1Decorator.shapes;

public abstract class ShapeDecorator implements Shape{
    protected Shape shape;

    public ShapeDecorator(Shape shape){
        this.shape = shape;
    }

    public ShapeDecorator() {

    }

    @Override
    public String draw() {
        return this.shape.draw();
    }
}
