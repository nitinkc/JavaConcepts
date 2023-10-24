package nitin.streams.parallelStreams;

import com.entity.EmployeeSimple;
import com.entity.SampleData;
import com.utilities.MultiThreadUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class P1Intro {
    public static void main(String[] args) {
        List<Integer> list = List.of(0,1,2,3,4,5,6,7,9,8);

        //sequential(list);
        //streamDotParallel(list.stream());
        //sequentialPitFalls(list);
        //parallelStreamWithoutOrder(list);
        //parallelStreamWithOrder(list);

        //reducePitfalls(list);

        //batchProcessing();

        //customFjp();

        for (int i = 0; i < 10; i++) {
            //findFirstParallel();
        }

        for (int i = 0; i < 10; i++) {
            findAnyParallel();
        }
    }

    private static void findFirstParallel() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //Find the name of the first employee greater than 40 years of age

        System.out.print(employees.parallelStream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .filter(emp -> emp.getAge() > 25)
                .map(emp -> emp.getName())
                .findFirst()//Ordered and thus yields same result in both parallel and sequential
                .orElse("No Emp Found"));

    }

    private static void findAnyParallel() {
        List<EmployeeSimple> employees = SampleData.getSimpleEmployees();

        //Find the name of the any employee greater than 25 years of age

        System.out.println(employees.parallelStream()
                .filter(Objects::nonNull).filter(emp -> null != emp.getAge()).filter(emp -> null != emp.getName())
                .filter(emp -> emp.getAge() > 25)
                .map(emp -> emp.getName())
                .findAny()//behaves erratically with Parallel stream. Runs fine with sequential execution
                .orElse("No Emp Found"));

    }

    private static void batchProcessing() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            list.add(i);
        }

        list.parallelStream()
                .filter(num -> num*1 == num)
                .map(num -> incrementWith1SecDelay(num))
                .forEach(e -> {});
    }

    private static void reducePitfalls(List<Integer> list) {
        Integer result = list
                .parallelStream()//Using Parallel Stream
                .reduce(30, //First Parameter is not INITIAL value, it's an identity
                        (total, e) -> add(total, e));

        System.out.println("Final Result : " + result);
    }

    private static Integer add(Integer a, Integer b) {
        int result = a + b;
        System.out.println("a = " + a + " b = " + b + " r = " + result + " " +Thread.currentThread());
        return result;
    }

    private static void sequentialPitFalls(List<Integer> list) {
        System.out.println("\nstreamDotParallel");
        list.parallelStream()
                .map(num -> incrementWith1SecDelay(num))
                .sequential()//This takes precedence due to its proximity with forEach (Reduce operation)
                .forEach(num -> System.out.print(num+" "));
    }

    private static void streamDotParallel(Stream<Integer> listStream) {
        System.out.println("\nstreamDotParallel");
        listStream.parallel()//if Stream is already provided,or outside our control
                .map(num -> incrementWith1SecDelay(num))
                .forEachOrdered(num -> System.out.print(num+" "));
    }

    private static void parallelStreamWithOrder(List<Integer> list) {
        System.out.println("\nparallel Stream With Order");
        list.parallelStream()//Simple conversion to parallel stream
                .map(num -> {
                    MultiThreadUtility.delay(1000);
                    num = num + 1;
                    System.out.println("map: " + num+"--" + Thread.currentThread());
                    return num;
                })
                .forEachOrdered(num -> System.out.println("feo: " + num+"--" + Thread.currentThread()));
    }

    private static void parallelStreamWithoutOrder(List<Integer> list) {
        System.out.println("\nparallel Stream Without Order");

        list.parallelStream()//Simple conversion to parallel stream
                .map(num -> {
                    MultiThreadUtility.delay(1000);
                    num = num + 1;
                    System.out.println("map: " + num+"--" + Thread.currentThread());
                    return num;
                })
                .forEach(num -> System.out.println("fe : " + num+"--" + Thread.currentThread()));
    }

    private static void sequential(List<Integer> list) {
        System.out.println("Sequential");

        list.stream()
                .sequential()//Without this method also it will work similar
                .map(num -> incrementWith1SecDelay(num))
                .forEach(num -> System.out.print(num+" "));
    }

    private static int incrementWith1SecDelay(int number){
        MultiThreadUtility.logMessage(String.valueOf(number));
        MultiThreadUtility.delay(1000);
        return number + 1;
    }

}
