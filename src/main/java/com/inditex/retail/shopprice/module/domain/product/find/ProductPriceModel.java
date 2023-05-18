package com.inditex.retail.shopprice.module.domain.product.find;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceModel {
    private Long id;
    private Long brandId;
    private String startDate;
    private String endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private String coin;
}
