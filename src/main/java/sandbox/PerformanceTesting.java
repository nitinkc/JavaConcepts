package sandbox;

public class PerformanceTesting {

    public static void main(String[] args) {
        int n = 100000; // Change this value as needed for different tests
        int iterations = 10; // Number of iterations for calculating average execution time

        // Warm-up to avoid JVM optimizations affecting initial results
        for (int i = 0; i < 5; i++) {
            calculateSum(n);
            concatenateStrings(n);
            performFloatingPointOperations(n);
        }

        long totalSumExecutionTime = 0;
        long totalConcatenationExecutionTime = 0;
        long totalFloatOperationsExecutionTime = 0;
        long totalSumMemoryUsed = 0;
        long totalConcatenationMemoryUsed = 0;
        long totalFloatOperationsMemoryUsed = 0;

        // Measure and benchmark the performance for sum calculation
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            calculateSum(n);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            totalSumExecutionTime += executionTime;

            // Perform a garbage collection to get more accurate memory usage
            System.gc();
            long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            totalSumMemoryUsed += memoryUsed;
        }

        // Measure and benchmark the performance for string concatenation
        String result = "";
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            result = concatenateStrings(n);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            totalConcatenationExecutionTime += executionTime;

            // Perform a garbage collection to get more accurate memory usage
            System.gc();
            long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            totalConcatenationMemoryUsed += memoryUsed;
        }

        // Measure and benchmark the performance for floating-point arithmetic operations
        float total = 0.0f;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            total = performFloatingPointOperations(n);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;
            totalFloatOperationsExecutionTime += executionTime;

            // Perform a garbage collection to get more accurate memory usage
            System.gc();
            long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            totalFloatOperationsMemoryUsed += memoryUsed;
        }

        double averageSumExecutionTimeInSeconds = totalSumExecutionTime / (iterations * 1_000_000_000.0);
        double averageConcatenationExecutionTimeInSeconds = totalConcatenationExecutionTime / (iterations * 1_000_000_000.0);
        double averageFloatOperationsExecutionTimeInSeconds = totalFloatOperationsExecutionTime / (iterations * 1_000_000_000.0);

        double averageSumMemoryUsedInMB = totalSumMemoryUsed / (iterations * (1024.0 * 1024.0));
        double averageConcatenationMemoryUsedInMB = totalConcatenationMemoryUsed / (iterations * (1024.0 * 1024.0));
        double averageFloatOperationsMemoryUsedInMB = totalFloatOperationsMemoryUsed / (iterations * (1024.0 * 1024.0));

        System.out.println("Average Sum Execution Time: " + averageSumExecutionTimeInSeconds + " seconds");
        System.out.println("Average Concatenation Execution Time: " + averageConcatenationExecutionTimeInSeconds + " seconds");
        System.out.println("Average Float Operations Execution Time: " + averageFloatOperationsExecutionTimeInSeconds + " seconds");

        System.out.println("Average Sum Memory Used: " + averageSumMemoryUsedInMB + " MB");
        System.out.println("Average Concatenation Memory Used: " + averageConcatenationMemoryUsedInMB + " MB");
        System.out.println("Average Float Operations Memory Used: " + averageFloatOperationsMemoryUsedInMB + " MB");

        // System.out.println("Result of string concatenation: " + result);
        System.out.println("Result of floating-point arithmetic: " + total);
    }

    public static long calculateSum(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static String concatenateStrings(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("String").append(i);
        }
        return sb.toString();
    }

    public static float performFloatingPointOperations(int n) {
        float total = 0.0f;
        for (int i = 1; i <= n; i++) {
            total += (float) (i * 0.5);
        }
        return total;
    }
}
