package com.nitin.ShareMarkets;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nichaurasia on Thursday, February/13/2020 at 2:49 PM
 */

public class AssetRunner {
    public static void main(String[] args) {
        List<Asset> assets = Arrays.asList(
                new Asset(Asset.AssetType.STOCK, 1000),
                new Asset(Asset.AssetType.STOCK, 2000),
                new Asset(Asset.AssetType.BOND,300),
                new Asset(Asset.AssetType.BOND, 500)
        );

        System.out.println("Sum of all Assets");
        System.out.println(AssetUtil.totalAssetValues(assets));

        System.out.println("Sum of all Assets of type Stock");
        System.out.println(AssetUtil
                .totalAssetValuesWithSelector(assets, asset -> asset.getAssetType() == Asset.AssetType.STOCK));

        System.out.println("Sum of all Assets of type Bond");
        System.out.println(AssetUtil.totalAssetValuesWithSelector(assets, asset -> asset.getAssetType() == Asset.AssetType.BOND));

    }
}
