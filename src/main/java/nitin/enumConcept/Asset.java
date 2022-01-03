package nitin.enumConcept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by nichaurasia on Thursday, February/13/2020 at 2:49 PM
 */

@Getter
@Setter
@AllArgsConstructor
public class Asset {
    public enum AssetType{BOND, STOCK, COMMODITY}

    private final AssetType assetType;
    private final int value;
}
