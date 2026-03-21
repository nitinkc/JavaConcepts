package nitin.cloning;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class DeepCloneTarget implements Cloneable {
    private int a;
    private String b;
    private MutableState state;

    @Override
    public DeepCloneTarget clone() throws CloneNotSupportedException {
        DeepCloneTarget copy = (DeepCloneTarget) super.clone();
        // Deep copy: create a fresh MutableState so changes don't leak across clones.
        copy.state = new MutableState(this.state.getMutableVar());
        return copy;
    }
}
