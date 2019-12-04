package com.nitin.a8designPatternsNPrinciples.Structural.S1Decorator.shapes;

public class TransparentShapeDecorator extends ShapeDecorator{
    private Shape shape;
    public TransparentShapeDecorator(Shape shape) {
        super(shape);
        this.shape = shape;
    }

    @Override
    public String draw() {
        String ret = this.draw() + " :: Transparent Shape";
        System.out.println(ret);
        return ret;
    }
}
