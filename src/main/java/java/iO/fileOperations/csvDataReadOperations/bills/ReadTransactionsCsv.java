package java.iO.fileOperations.csvDataReadOperations.bills;

import java.iO.fileOperations.csvDataReadOperations.bills.entity.Currency;
import java.iO.fileOperations.csvDataReadOperations.bills.entity.Transaction;
import java.iO.fileOperations.csvDataReadOperations.bills.entity.Transactions;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Created by nichaurasia
 * @create on Tuesday, September/29/2020 at 11:23 PM
 */

public class ReadTransactionsCsv {
    public static List<Transaction> getData () {
        String file = "JavaLatest/src/main/java/com/fileOperations/csvDataReadOperations/bills/transactions.csv";

        return readFileNreturnList(file);
    }

    private static List<Transaction> readFileNreturnList(String file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Transaction> entityList = reader.lines().skip(1)
                //.limit(200)
                .map(line -> line.split(","))
                .map(ReadTransactionsCsv::makeObjects)
                .collect(Collectors.toList());

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entityList;
    }


    private static Transaction makeObjects(String[] line) {
        Transaction e = null;
        //int id, double value, Currency currency, Transactions type, String city
        e =  new Transaction(
                NumberUtils.toInt(line[0]),
                NumberUtils.toDouble(line[1]),
                Currency.valueOf(line[2]),
                Transactions.valueOf(line[3]),
                line[4]
        );

        //System.out.println(e);
        return e;
    }
}