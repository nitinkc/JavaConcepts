package java.enumConcept;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by nichaurasia on Thursday, February/13/2020 at 2:49 PM
 */

public class AssetUtil {

    public static int totalAssetValues(final List<Asset> assets){
        return assets.stream()
                //.filter(asset -> asset.getAssetType() == Asset.AssetType.STOCK)
                .filter(asset -> true)
                .mapToInt(Asset::getValue)
                .sum();
    }

    public static int totalAssetValuesWithSelector(final List<Asset> assets, final Predicate<Asset> assetSelector){

        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }

    private AssetUtil(){}
}
