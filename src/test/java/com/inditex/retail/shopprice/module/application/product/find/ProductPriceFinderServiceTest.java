package com.inditex.retail.shopprice.module.application.product.find;

import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderFilter;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderRepository;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderResponse;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceModel;
import com.inditex.retail.shopprice.module.product.domain.finder.ProductPriceFinderFilterMother;
import com.inditex.retail.shopprice.module.product.domain.finder.ProductPriceModelMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductPriceFinderServiceTest {
    @InjectMocks
    private ProductPriceFinderService finderService;
    @Mock
    private ProductPriceFinderRepository productPriceFinderRepository;

    @Test
    @DisplayName("findPrice() -> [OK] -> when data are found")
    void findPrice_shouldReturnDataWhenDataAreFound() {
        final ProductPriceFinderFilter request = ProductPriceFinderFilterMother.empty();
        final List<ProductPriceModel> dataFound = ProductPriceModelMother.list();

        when(productPriceFinderRepository.findPrice(request)).thenReturn(Optional.of(dataFound));

        final List<ProductPriceFinderResponse> response = finderService.findPrice(request);
        assertNotNull(response);
        assertFalse(response.isEmpty());
    }

    @Test
    @DisplayName("findPrice() -> [OK] -> when data are found")
    void findPrice_shouldReturnDataWhenAllFilterAndDataAreFound() {
        final ProductPriceFinderFilter request = ProductPriceFinderFilterMother.all();
        final List<ProductPriceModel> dataFound = ProductPriceModelMother.list();

        when(productPriceFinderRepository.findPrice(request)).thenReturn(Optional.of(dataFound));

        final List<ProductPriceFinderResponse> response = finderService.findPrice(request);
        assertNotNull(response);
        assertFalse(response.isEmpty());
    }

    @Test
    @DisplayName("findPrice() -> [OK] -> empty list when data are not found")
    void findPrice_shouldReturnEmptyListWhenDataAreNotFound () {
        final ProductPriceFinderFilter request = ProductPriceFinderFilterMother.empty();

        when(productPriceFinderRepository.findPrice(request)).thenReturn(Optional.empty());

        final List<ProductPriceFinderResponse> response = finderService.findPrice(request);
        assertNotNull(response);
        assertTrue(response.isEmpty());
    }
}