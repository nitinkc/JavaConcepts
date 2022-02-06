package nitin.streams.t2Streams.streams2.parallel;


import nitin.LambdaExpressions.t1Lambdas.lambdasInCollection.timing.Op;

public class ParallelTests {
    public static void main(String[] args) {
        //compareOutput();
        compareTiming();
    }

    public static void compareOutput() {
        double[] nums = MathUtils.randomNums(10_000_000);
        double result1 = MathUtils.fancySum1(nums);
        System.out.printf("Serial result   = %,.12f%n", result1);
        double result2 = MathUtils.fancySum2(nums);
        System.out.printf("Parallel result = %,.12f%n", result2);
    }

    public static void compareTiming() {
        for (int i = 5; i < 9; i++) {
            int size = (int) Math.pow(10, i);
            double[] nums = MathUtils.randomNums(size);
            Op serialSum = () -> MathUtils.fancySum1(nums);
            Op parallelSum = () -> MathUtils.fancySum2(nums);
            System.out.printf("Serial sum for length   %,d.%n", size);
            double serialTime = Op.timeOp(serialSum);
            double parallelTime = Op.timeOp(parallelSum);
            System.out.printf("  Elapsed time: %.3f seconds.%n", serialTime);
            System.out.printf("Parallel sum for length %,d.%n", size);
            System.out.printf("  Elapsed time: %.3f seconds.%n", parallelTime);

            Op.timeOp(parallelSum);
            System.out.printf("Percent Difference %.3f %n", ((serialTime - parallelTime) / parallelTime) * 100);
        }
    }
}
