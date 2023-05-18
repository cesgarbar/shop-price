package com.inditex.retail.shopprice.module.infrastructure.out.db.repositories;

import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderFilter;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderQuery;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderQueryMother;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceModel;
import com.inditex.retail.shopprice.module.infrastructure.out.db.repositories.H2JpaProductPriceFinderRepository;
import com.inditex.retail.shopprice.module.product.domain.finder.ProductPriceFinderFilterMother;
import com.inditex.retail.shopprice.module.shared.utils.DataBaseConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class H2JpaProductPriceFinderRepositoryTest {
    @InjectMocks
    private H2JpaProductPriceFinderRepository finderRepository;
    @Mock
    private EntityManager entityManager;
    @Mock
    private TypedQuery<ProductPriceFinderQuery> typedQuery;

    @Test
    @DisplayName("findPrice() -> [OK] -> when data are found")
    void findPrice_shouldReturnDataWhenDataAreFound () {
        final ProductPriceFinderFilter request = ProductPriceFinderFilterMother.empty();
        final List<ProductPriceFinderQuery> dataFound = ProductPriceFinderQueryMother.list();


        when(entityManager.createQuery(anyString(), eq(ProductPriceFinderQuery.class))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(dataFound);


        final Optional<List<ProductPriceModel>> response = finderRepository.findPrice(request);
        assertNotNull(response);
        assertFalse(response.isEmpty());
    }

    @Test
    @DisplayName("findPrice() -> [OK] -> when all filter all data are found")
    void findPrice_shouldReturnDataWhenAllFilterAllDataAreFound () {
        final ProductPriceFinderFilter request = ProductPriceFinderFilterMother.all();
        final List<ProductPriceFinderQuery> dataFound = ProductPriceFinderQueryMother.list();


        when(entityManager.createQuery(anyString(), eq(ProductPriceFinderQuery.class))).thenReturn(typedQuery);
        when(typedQuery.setParameter("productId", request.getProductId())).thenReturn(typedQuery);
        when(typedQuery.setParameter("brandId", request.getBrandId())).thenReturn(typedQuery);
        when(typedQuery.setParameter("dateQuery", new DataBaseConverter().stringToDate(request.getDate()))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(dataFound);


        final Optional<List<ProductPriceModel>> response = finderRepository.findPrice(request);
        assertNotNull(response);
        assertFalse(response.isEmpty());
    }
    @Test
    @DisplayName("findPrice() -> [OK] -> when data not found")
    void findPrice_shouldReturnEmptyWhenDataNotFound () {
        final ProductPriceFinderFilter request = ProductPriceFinderFilterMother.all();
        final List<ProductPriceFinderQuery> emptyList = new ArrayList<>();

        when(entityManager.createQuery(anyString(), eq(ProductPriceFinderQuery.class))).thenReturn(typedQuery);
        when(typedQuery.setParameter("productId", request.getProductId())).thenReturn(typedQuery);
        when(typedQuery.setParameter("brandId", request.getBrandId())).thenReturn(typedQuery);
        when(typedQuery.setParameter("dateQuery", new DataBaseConverter().stringToDate(request.getDate()))).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(emptyList);

        final Optional<List<ProductPriceModel>> response = finderRepository.findPrice(request);
        assertNotNull(response);
        assertTrue(response.isEmpty());
    }
}