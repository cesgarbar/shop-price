package com.inditex.retail.shopprice.module.infrastructure.out.db.entities;

import com.inditex.retail.shopprice.app.constants.AppConstants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = AppConstants.Tables.TABLE_NAME_PRODUCT_PRICE)
public class ProductPriceEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "BRAND_ID")
    private Long brandId;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "PRICE_LIST")
    private Long priceList;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "PRIORITY")
    private Integer priority;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "CURR")
    private String coin;
}
