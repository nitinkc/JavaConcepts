package nitin.exceptionHandling.inFunctionalProgramming;

import java.util.List;

public class E4ExceptionsAndFunctionalProgramming {
    public static void main(String[] args) {

        final int dividend = 1234567;
        List<Integer> listDivisor = List.of(100, 34, 56, 78,0, 98,49);

        listDivisor.stream()
                //.map(number -> divide(number, divisor))//try catch -> Incorrect as Functional Programming and Exception handling are mutually exclusive
                .map(singleDivisor -> tryDivide(dividend, singleDivisor))
                .map(result -> result.map(num -> num + 1))
                .map(result -> switch (result){
                    case Success data -> data.getResult();
                    case Failure err-> err.getError();
                })
                .forEach(System.out::println);


       /*List updatedList = listDivisor.stream()
                //.map(number -> divide(number, divisor))//try catch -> Incorrect as Functional Programming and Exception handling are mutually exclusive
                .map(singleDivisor -> tryDivide(dividend, singleDivisor))
                .map(result -> result.map(num -> num+1))
                .map(result ->  switch (result){
                    case Success data -> data.getResult();
                    case Failure err -> err.getError();
                })
                .toList();
        System.out.println(updatedList);*/
    }

    

    //If a method throws an IO exception and it has to be used in a Labmda,
    public static Integer divide(Integer divident, Integer divisor) throws ArithmeticException {
        return divident/divisor;
    }

    public static Try<Integer> tryDivide(Integer dividend, Integer divisor){
        return Try.of(() -> divide(dividend,divisor));
    }

}
