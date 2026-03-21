package nitin.cloning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/** If the Cloneable Interface is not implemented it throws CloneNotSupportedException */
@Getter
@Setter
@AllArgsConstructor
class Stock implements Cloneable {
    int price;
    String name;

    // Compulsory Implementation
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
