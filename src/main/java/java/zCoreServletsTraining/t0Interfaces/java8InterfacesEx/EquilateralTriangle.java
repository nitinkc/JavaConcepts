package java.zCoreServletsTraining.t0Interfaces.java8InterfacesEx;

public class EquilateralTriangle implements RegularPolygon {
  private double sideLength;
  
  public EquilateralTriangle(double sideLength) {
    this.sideLength = Math.abs(sideLength);
  }

  @Override
  public int getNumSides() {
    return(3);
  }
  
  @Override
  public double getSideLength() {
    return(sideLength);
  }

  @Override
  public String toString() {
    return(String.format("EquilateralTriangle with side length=%6.3f, perimeter=%6.3f, and interior angle %5.3f radians.\n",
                         sideLength, getPerimeter(), getInteriorAngle()));
  }
}
