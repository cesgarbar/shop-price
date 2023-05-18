package com.inditex.retail.shopprice.module.domain.product.find;

import com.inditex.retail.shopprice.module.shared.validator.DateTimeValidator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPriceFinderRequest {
    @DateTimeValidator()
    private String date;
    private Long brandId;
    private Long productId;
}
