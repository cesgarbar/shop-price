package com.inditex.retail.shopprice.module.infrastructure.out.db.repositories;

import com.inditex.retail.shopprice.module.domain.product.converter.ProductPriceConverter;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderFilter;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderQuery;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceFinderRepository;
import com.inditex.retail.shopprice.module.domain.product.find.ProductPriceModel;
import com.inditex.retail.shopprice.module.shared.utils.DataBaseConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Slf4j
@Primary
@Repository
public class H2JpaProductPriceFinderRepository implements ProductPriceFinderRepository {

    private static final String QUERY = "SELECT new com.inditex.retail.shopprice.module.domain.product.find." +
            "ProductPriceFinderQuery(" +
            "id, brandId, startDate, endDate, priceList, productId, priority, price, coin) " +
            "FROM ProductPriceEntity " +
            "WHERE 1=1 ";

    private final EntityManager entityManager;
    private final ProductPriceConverter converter;
    private final DataBaseConverter dataBaseConverter;

    public H2JpaProductPriceFinderRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
        this.converter = new ProductPriceConverter();
        this.dataBaseConverter = new DataBaseConverter();
    }

    @Override
    public Optional<List<ProductPriceModel>> findPrice(final ProductPriceFinderFilter filter) {
        final StringBuilder querySql = new StringBuilder();
        querySql.append(QUERY);

        addQueryConditions(filter, querySql);

        log.info("Consulta SQL: {}", querySql);
        log.info("Parámetros: productId={}, brandId={}, dateQuery={}, ", filter.getProductId(), filter.getBrandId(), filter.getDate());
        final TypedQuery<ProductPriceFinderQuery> query = entityManager.createQuery(querySql.toString(), ProductPriceFinderQuery.class);

        addQueryParameter(filter, query);

        final List<ProductPriceFinderQuery> dataFound = query.getResultList();
        if (dataFound.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(converter.listFinderQueryEntityToListModel(dataFound));
    }

    private void addQueryConditions(final ProductPriceFinderFilter filter, final StringBuilder querySql) {
        if (null != filter.getProductId()) {
            querySql.append(" AND productId = :productId ");
        }
        if (null != filter.getBrandId()) {
            querySql.append(" AND brandId = :brandId ");
        }
        if (null != filter.getDate()) {
            querySql.append(" AND startDate <= :dateQuery AND endDate >= :dateQuery");
        }
    }

    private void addQueryParameter(final ProductPriceFinderFilter filter, final TypedQuery<ProductPriceFinderQuery> query) {
        if (null != filter.getProductId()) {
            query.setParameter("productId", filter.getProductId());
        }
        if (null != filter.getBrandId()) {
            query.setParameter("brandId", filter.getBrandId());
        }
        if (null != filter.getDate()) {
            query.setParameter("dateQuery", dataBaseConverter.stringToDate(filter.getDate()));
        }
    }
}
