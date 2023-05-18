package com.inditex.retail.shopprice.module.product.domain.finder;

import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderFilter;

public class ProductPriceFinderFilterMother {
    public static ProductPriceFinderFilter empty() {
        return new ProductPriceFinderFilter();
    }

    public static ProductPriceFinderFilter all() {
        final ProductPriceFinderFilter filter = new ProductPriceFinderFilter();
        filter.setProductId(-1001L);
        filter.setBrandId(-1001L);
        filter.setDate("2023-05-18 10:00:00");
        return filter;
    }
}
