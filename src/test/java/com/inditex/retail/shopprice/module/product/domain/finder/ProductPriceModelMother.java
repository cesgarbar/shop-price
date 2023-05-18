package com.inditex.retail.shopprice.module.product.domain.finder;

import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceModel;

import java.util.ArrayList;
import java.util.List;

public class ProductPriceModelMother {
    public static List<ProductPriceModel> list() {
        final List<ProductPriceModel> list = new ArrayList<>();
        list.add(fixedByIdAndProductId(-1001L, -1001L));
        return list;
    }

    private static ProductPriceModel fixedByIdAndProductId(final long id, final long productId) {
        final ProductPriceModel model = new ProductPriceModel();
        model.setId(id);
        model.setBrandId(-1001L);
        model.setStartDate("2023-05-18 10:00:00");
        model.setEndDate("2023-05-18 15:00:00");
        model.setPriceList(1L);
        model.setProductId(productId);
        model.setPriority(1);
        model.setPrice(35.20);
        model.setCoin("EUR");
        return model;
    }
}
