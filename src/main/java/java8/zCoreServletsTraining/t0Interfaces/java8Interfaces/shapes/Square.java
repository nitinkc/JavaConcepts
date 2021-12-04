package java8.zCoreServletsTraining.t0Interfaces.java8Interfaces.shapes;
/** Represents a simplistic Square. Designed so that squares are rectangles,
 *  although it is not entirely clear that this is the best design in real
 *  life, as discussed on the exercise handout.
 */

public class Square extends Rectangle {
  public Square(double width) {
    super(width, width);
  }

  @Override
  public double getHeight() {
    return(getWidth());
  }

  private void setSides(double side) {
    super.setWidth(side);
    super.setHeight(side);
  }
  
  @Override
  public void setHeight(double height) {
    setSides(height);
  }
  
  @Override
  public void setWidth(double width) {
    setSides(width);
  }

  public void setArea(double area) {
    setWidth(Math.sqrt(area));
  }
}