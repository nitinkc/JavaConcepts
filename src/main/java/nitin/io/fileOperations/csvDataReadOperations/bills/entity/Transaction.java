package nitin.io.fileOperations.csvDataReadOperations.bills.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Created by nichaurasia Created on Wednesday, September/30/2020 at 6:46 PM
 */
@Getter
@Setter
@ToString
public class Transaction {
    private int id;
    private double value;
    private Currency currency;
    private Transactions type;
    private String city;

    public Transaction(int id, double value, Currency currency, Transactions type, String city) {
        this.id = id;
        this.value = value;
        this.currency = currency;
        this.type = type;
        this.city = city;
    }
}
