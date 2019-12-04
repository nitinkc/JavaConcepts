package com.nitin.a8designPatternsNPrinciples.Structural.S1Decorator.shapes;

public class ShadedShapeDecorator extends ShapeDecorator {

    private Shape shape;

    public ShadedShapeDecorator(Shape shape) {
        super(shape);
        this.shape = shape;
    }

    @Override
    public String draw() {
        String ret = this.draw() + " :: Shaded Shape";
        System.out.println(ret);
        return ret;
    }
}
