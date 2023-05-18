package com.inditex.retail.shopprice.module.product.domain.finder;

import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderResponse;

import java.util.ArrayList;
import java.util.List;

public class ProductPriceFinderResponseMother {
    public static List<ProductPriceFinderResponse> findAll() {
        final List<ProductPriceFinderResponse> list = new ArrayList<>();
        list.add(fixedByProductId(-1001L));
        list.add(fixedByProductId(-1002L));
        return list;
    }

    private static ProductPriceFinderResponse fixedByProductId(final long productId) {
        final ProductPriceFinderResponse response = new ProductPriceFinderResponse();
        response.setProductId(productId);
        response.setBrandId(-1001L);
        response.setPrice(35.20);
        response.setFinalPrice(36.88);
        response.setStartDate("2023-05-18 10:00:00");
        response.setEndDate("2023-05-18 15:00:00");
        return response;
    }
}
