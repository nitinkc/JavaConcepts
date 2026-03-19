package nitin.cloning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class ShallowCloneTarget implements Cloneable {
    private int a;
    private String b;
    private MutableState state;

    @Override
    public ShallowCloneTarget clone() throws CloneNotSupportedException {
        // Shallow copy: the MutableState reference is shared between original and clone.
        return (ShallowCloneTarget) super.clone();
    }
}

