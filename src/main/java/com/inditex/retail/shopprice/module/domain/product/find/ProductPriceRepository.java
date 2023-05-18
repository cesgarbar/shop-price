package com.inditex.retail.shopprice.module.domain.product.find;

import com.inditex.retail.shopprice.module.infrastructure.out.db.entities.ProductPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(transactionManager = "transactionManager")
public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, Long> {
}
