package com.inditex.retail.shopprice.module.infrastructure.in.http.find;

import com.inditex.retail.shopprice.module.application.product.find.ProductPriceFinderService;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderRequest;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderResponse;
import com.inditex.retail.shopprice.module.product.domain.finder.ProductPriceFinderRequestMother;
import com.inditex.retail.shopprice.module.product.domain.finder.ProductPriceFinderResponseMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductPriceFinderControllerTest {
    @InjectMocks
    private ProductPriceFinderController finderController;
    @Mock
    private ProductPriceFinderService productPriceFinderService;

    @Test
    @DisplayName("findPrice() -> [OK] -> when data are found")
    void findPrice_shouldReturnDataWhenDataAreFound () {
        final ProductPriceFinderRequest request = ProductPriceFinderRequestMother.empty();
        final List<ProductPriceFinderResponse> dataFound = ProductPriceFinderResponseMother.findAll();

        when(productPriceFinderService.findPrice(any())).thenReturn(dataFound);

        final ResponseEntity<List<ProductPriceFinderResponse>> response = finderController.findPrice(request);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    @DisplayName("findPrice() -> [OK] -> when data are found")
    void findPrice_shouldReturnDataWhenAllFilterAndDataAreFound () {
        final ProductPriceFinderRequest request = ProductPriceFinderRequestMother.all();
        final List<ProductPriceFinderResponse> dataFound = ProductPriceFinderResponseMother.findAll();

        when(productPriceFinderService.findPrice(any())).thenReturn(dataFound);

        final ResponseEntity<List<ProductPriceFinderResponse>> response = finderController.findPrice(request);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

}