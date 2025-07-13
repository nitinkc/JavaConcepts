package nitin.generic.boundedType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Created by nichaurasia Created on Tuesday, September/29/2020 at 2:28 AM
 */
@Getter
@Setter
public class Box<T> {

    private T t;

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
}
