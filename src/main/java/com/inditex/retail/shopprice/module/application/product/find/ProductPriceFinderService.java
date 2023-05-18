package com.inditex.retail.shopprice.module.application.product.find;

import com.inditex.retail.shopprice.module.domain.product.converter.ProductPriceConverter;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderFilter;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderRepository;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderResponse;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductPriceFinderService {

    private final ProductPriceFinderRepository productPriceFinderRepository;
    private final ProductPriceConverter converter;

    public ProductPriceFinderService(final ProductPriceFinderRepository productPriceFinderRepository) {
        this.productPriceFinderRepository = productPriceFinderRepository;
        this.converter = new ProductPriceConverter();
    }

    public List<ProductPriceFinderResponse> findPrice(final ProductPriceFinderFilter filter) {
        final Optional<List<ProductPriceModel>> found = productPriceFinderRepository.findPrice(filter);
        if(found.isEmpty()){
            return new ArrayList<>();
        }
        return converter.listModelToListResponse(found.get());
    }
}
