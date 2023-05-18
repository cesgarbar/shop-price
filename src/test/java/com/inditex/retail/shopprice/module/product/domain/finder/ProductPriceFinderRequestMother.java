package com.inditex.retail.shopprice.module.product.domain.finder;

import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderRequest;

public class ProductPriceFinderRequestMother {
    public static ProductPriceFinderRequest empty() {
        return new ProductPriceFinderRequest();
    }

    public static ProductPriceFinderRequest all() {
        final ProductPriceFinderRequest request = new ProductPriceFinderRequest();
        request.setProductId(-1001L);
        request.setBrandId(-1001L);
        request.setDate("2023-05-18 10:00:00");
        return request;
    }
}
