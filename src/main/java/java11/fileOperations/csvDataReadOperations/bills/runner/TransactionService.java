package java11.fileOperations.csvDataReadOperations.bills.runner;

import java11.fileOperations.csvDataReadOperations.bills.ReadTransactionsCsv;
import java11.fileOperations.csvDataReadOperations.bills.entity.Transaction;
import java11.fileOperations.csvDataReadOperations.bills.entity.Transactions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Created by nichaurasia
 * @create on Wednesday, September/30/2020 at 7:43 PM
 */

// https://www.oracle.com/technical-resources/articles/java/architect-streams-pt2.html
public class TransactionService {
    public static void main(String[] args) {
        List<Transaction> transactions = ReadTransactionsCsv.getData();
        System.out.println("Total number of records : " + transactions.size());

        System.out.println("**************************************************************");
        System.out.println("Get id's all Groceries types");
        List<Integer> transactionsIds =
                getTransIdGroceries(transactions);

        System.out.println(transactionsIds);

        System.out.println("**************************************************************");
        System.out.println("Get id's all Groceries types");
        boolean expensive =
                transactions.stream()
                        .allMatch(t -> t.getValue() > 100);

        System.out.println("**************************************************************");
        System.out.println("Get sum of all the Tx's in Delhi using maptoDouble");
        Double statementSum =
                getSumCity(transactions);
        System.out.println(statementSum);

        System.out.println("**************************************************************");
        System.out.println("Get sum of all the Tx's in Delhi using maptoDouble");
        Double statementSumReduce =
                getSumCityReduce(transactions);
        System.out.println(statementSumReduce);
    }

    private static Double getSumCityReduce(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getCity().equalsIgnoreCase("Delhi"))
                .map(Transaction::getValue)
                .reduce(Double::sum)
                .get();
    }

    private static double getSumCity(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getCity().equalsIgnoreCase("Delhi"))
                .mapToDouble(Transaction::getValue)
                .sum();
    }

    private static List<Integer> getTransIdGroceries(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getType() == Transactions.GROCERY)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .map(Transaction::getId)
                .collect(Collectors.toList());
    }
}
