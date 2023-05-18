package com.inditex.retail.shopprice.module.domain.product.find;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPriceFinderFilter {
    private String date;
    private Long brandId;
    private Long productId;
}
