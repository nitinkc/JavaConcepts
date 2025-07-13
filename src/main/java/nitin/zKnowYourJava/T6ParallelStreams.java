package nitin.zKnowYourJava;

import java.util.List;

public class T6ParallelStreams {
    public static void main(String[] args) {
        // Which Thread will transform method run
        List.of(1, 2, 3).parallelStream()
                .map(number -> transform(number))
                // .sequential()//The **last setting** overrides the entire pipeline.
                .forEach(number -> print(number));
    }

    public static int transform(int number) {
        System.out.println("Transform() :: " + Thread.currentThread());
        return number * 2;
    }

    public static void print(int number) {
        System.out.println("Print() :: " + Thread.currentThread());
    }
}
