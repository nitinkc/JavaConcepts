package nitin.performance;

public class CompilationDemo {
    public CompilationDemo() {}

    // java -XX:+TieredCompilation -XX:+PrintCompilation CompilationDemo
    public static int compute(int x) {
        return x * x;
    }

    // A method that repeatedly calls the compute method
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            // The repeated calls to the compute method simulate a scenario where certain methods
            // become
            // hotspots and are prime candidates for compilation
            int compute = compute(i);
            // System.out.println(compute);
        }
    }
}
