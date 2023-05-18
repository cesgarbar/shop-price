package com.inditex.retail.shopprice.module.domain.product.find;

import java.util.List;
import java.util.Optional;

public interface ProductPriceFinderRepository {
    Optional<List<ProductPriceModel>> findPrice(ProductPriceFinderFilter filter);
}
