package com.nitin.a8designPatternsNPrinciples.Structural.S1Decorator.shapes;

public class ColoredShapeDecorator extends ShapeDecorator {
    private Shape shape;

    public ColoredShapeDecorator(Shape shape) {
        super(shape);
        this.shape = shape;
    }

    @Override
    public String draw() {
        String ret = this.draw() + " :: Colored Shape";
        System.out.println(ret);
        return ret;
    }
}
