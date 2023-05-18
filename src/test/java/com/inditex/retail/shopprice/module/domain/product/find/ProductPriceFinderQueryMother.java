package com.inditex.retail.shopprice.module.domain.product.find;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductPriceFinderQueryMother {
    public static List<ProductPriceFinderQuery> list() {
        final List<ProductPriceFinderQuery> list = new ArrayList<>();
        list.add(fixedById(-1001L));
        list.add(fixedById(-1002L));
        return list;
    }

    private static ProductPriceFinderQuery fixedById(final long id) {
        final ProductPriceFinderQuery query = new ProductPriceFinderQuery();
        query.setId(id);
        query.setBrandId(-1001L);
        query.setStartDate(new Date());
        query.setEndDate(new Date());
        query.setPriceList(1L);
        query.setProductId(-1001L);
        query.setPriority(1);
        query.setPrice(35.20);
        query.setCoin("EUR");
        return query;
    }
}
