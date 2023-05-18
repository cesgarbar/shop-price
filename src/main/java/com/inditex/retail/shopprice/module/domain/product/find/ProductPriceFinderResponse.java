package com.inditex.retail.shopprice.module.domain.product.find;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPriceFinderResponse {
    private Long productId;
    private Long brandId;
    private Double price;
    private String startDate;
    private String endDate;
    private Double finalPrice;
}
