package nitin.cloning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** If the Cloneable Interface is not implemented it throws CloneNotSupportedException */
@Getter
@Setter
@AllArgsConstructor
@ToString
class Stock implements Cloneable {
    int price;
    String name;

    // Compulsory Implementation
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
