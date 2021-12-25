package sandbox.SOLID;

public class Square implements Shape{
    @Override
    public Double area(Double... args) {
        double size = args[0];
        return size*size;
    }

    @Override
    public Double perimeter(Double... args) {
        double size = args[0];
        return size+size;
    }

    @Override
    public String description() {
        return "Square";
    }
}
