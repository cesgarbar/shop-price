package com.inditex.retail.shopprice.module.infrastructure.in.http.find;

import com.google.gson.Gson;
import com.inditex.retail.shopprice.module.application.product.find.ProductPriceFinderService;
import com.inditex.retail.shopprice.module.domain.product.converter.ProductPriceConverter;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderFilter;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderRequest;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductPriceFinderController {

    private final ProductPriceFinderService productPriceFinderService;
    private final ProductPriceConverter converter;
    private final Gson gson;

    public ProductPriceFinderController(final ProductPriceFinderService productPriceFinderService) {
        this.productPriceFinderService = productPriceFinderService;
        this.gson = new Gson();
        this.converter = new ProductPriceConverter();
    }

    @GetMapping(value = "/prices")
    public ResponseEntity<List<ProductPriceFinderResponse>> findPrice(final ProductPriceFinderRequest request) {
        log.info("Request: {}", gson.toJson(request));

        final ProductPriceFinderFilter filter = converter.requestToFilter(request);

        final List<ProductPriceFinderResponse> response = productPriceFinderService.findPrice(filter);

        log.info("Response: size={}", gson.toJson(response.size()));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
