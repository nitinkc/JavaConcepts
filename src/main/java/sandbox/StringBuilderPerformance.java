package sandbox;

import org.apache.commons.lang3.time.StopWatch;

public class StringBuilderPerformance {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StopWatch stopWatch = new StopWatch();

        for (int i = 0; i < 100; i++) {
            stopWatch.reset();
            stopWatch.start();
            for (int j = 0; j < 100; j++) {
                sb.append(j).append(",");
            }
            sb.append(i).append(",");
            stopWatch.stop();
            System.out.println(
                    "Total Execution Time in milliseconds: " + stopWatch.getTime() + " ms");
            sb.setLength(0);
        }
    }
}
