package nitin.streams.collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.utilities.JsonUtils.getJsonStringFromFile;

public class TransactionFlatMapAndGroupByMonthExample {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        objectMapper.registerModule(new JavaTimeModule());

        String filePath = "src/main/resources/json/transactions.json";
        List<Transaction> transactions = objectMapper.readValue(new File(filePath), new TypeReference<List<Transaction>>() {
        });

        // FlatMap transactions to items, sum by item name, and then group totals by month
        Map<YearMonth, Map<String, Integer>> sortedMap = transactions.stream()
                .flatMap(transaction -> transaction.getItems().stream()
                        .map(item -> new TransactionItem(
                                YearMonth.from(transaction.getDate()),
                                item.getName(), item.getAmount())))
                .collect(Collectors.groupingBy(
                        TransactionItem::getMonthAndYear,
                        TreeMap::new, // Use TreeMap to sort by key (YearMonth)
                        Collectors.groupingBy(
                                TransactionItem::getItemName,
                                Collectors.summingInt(TransactionItem::getAmount))
                ));

        // Sort the amounts for each item within each month in decreasing order
        sortedMap.replaceAll((month, itemTotals) ->
                itemTotals.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new)));

        // Print the sorted map
        sortedMap.forEach((month, itemTotals) -> {
            System.out.println("Month: " + month.format(DateTimeFormatter.ofPattern("MMM yyyy")));
            itemTotals.forEach((item, total) ->
                    System.out.println("    " + item + ": $" + total));
        });
    }
}

// Define the Transaction class
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Transaction {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private List<Item> items;
}

// Define the Item class
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Item {
    private String name;
    private int amount;
}

// Define the TransactionItem class to hold flatMap results
@Getter
@AllArgsConstructor
@NoArgsConstructor
class TransactionItem {
    private YearMonth monthAndYear; // Custom key combining month and year
    private String itemName;
    private int amount;
}