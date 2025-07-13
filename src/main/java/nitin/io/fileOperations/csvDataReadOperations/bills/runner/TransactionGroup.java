package nitin.io.fileOperations.csvDataReadOperations.bills.runner;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import nitin.io.fileOperations.csvDataReadOperations.bills.ReadTransactionsCsv;
import nitin.io.fileOperations.csvDataReadOperations.bills.entity.Transaction;

/**
 * @author Created by nichaurasia Created on Wednesday, September/30/2020 at 10:26 PM
 */

// https://www.oracle.com/technical-resources/articles/java/architect-streams-pt2.html
public class TransactionGroup {
    private static final Comparator<Map.Entry<String, Double>> valueOrder =
            Map.Entry.comparingByValue();
    private static final Comparator<Map.Entry<String, Double>> reversedValueOrder =
            valueOrder.reversed();

    public static void main(String[] args) {
        List<Transaction> transactions = ReadTransactionsCsv.getData();

        System.out.println("**************************************************************");
        System.out.println("Get sum of all the Tx's in each city using maptoDouble");
        // Map<String, Double> mapCitySum =
        transactions.stream()
                .collect(
                        Collectors.groupingBy(
                                Transaction::getCity,
                                Collectors.summingDouble(Transaction::getValue)))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("**************************************************************");
        System.out.println("Get sum of all the Tx's in each currency");
        // Map<String, Double> mapCitySum =
        transactions.stream()
                .collect(
                        Collectors.groupingBy(
                                Transaction::getCurrency,
                                Collectors.summingDouble(Transaction::getValue)))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("**************************************************************");
        System.out.println("Get sum of all the Tx's of each type");
        // Map<String, Double> mapCitySum =
        transactions.stream()
                .collect(
                        Collectors.groupingBy(
                                Transaction::getType,
                                Collectors.summingDouble(Transaction::getValue)))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("**************************************************************");
        System.out.println("Get max amount by each City");

        getMaxAmountByCity(transactions);

        transactions.stream()
                .collect(
                        Collectors.groupingBy(
                                Transaction::getCity,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(Transaction::getValue))))
                .values()
                .stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .sorted(Comparator.comparingDouble(Transaction::getValue).reversed())
                .limit(10)
                .forEach(System.out::println);
    }

    private static void getMaxAmountByCity(List<Transaction> transactions) {
        transactions.stream()
                // .collect(Collectors.groupingBy(Transaction::getCity,
                //         Collectors.maxBy(Comparator.comparing(Transaction::getValue))))
                .collect(
                        Collectors.groupingBy(
                                Transaction::getCity,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparing(Transaction::getValue)),
                                        optional -> optional.get().getValue())))
                .entrySet()
                .stream()
                .sorted(reversedValueOrder)
                .limit(10)
                .forEach(l -> System.out.printf("%20s : %5f\n", l.getKey(), l.getValue()));
    }
}
