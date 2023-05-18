package com.inditex.retail.shopprice.module.domain.product.converter;

import com.inditex.retail.shopprice.module.domain.product.find.*;
import com.inditex.retail.shopprice.module.infrastructure.out.db.entities.ProductPriceEntity;
import com.inditex.retail.shopprice.module.shared.utils.DataBaseConverter;

import java.util.ArrayList;
import java.util.List;

public class ProductPriceConverter {

    private final DataBaseConverter dataBaseConverter;

    public ProductPriceConverter() {
        this.dataBaseConverter = new DataBaseConverter();
    }

    public ProductPriceFinderFilter requestToFilter(final ProductPriceFinderRequest request) {
        final ProductPriceFinderFilter filter = new ProductPriceFinderFilter();
        filter.setDate(request.getDate());
        filter.setBrandId(request.getBrandId());
        filter.setProductId(request.getProductId());
        return filter;
    }

    public List<ProductPriceFinderResponse> listModelToListResponse(final List<ProductPriceModel> entities) {
        final List<ProductPriceFinderResponse> listResponse = new ArrayList<>();
        entities.forEach(entity -> listResponse.add(modelToResponse(entity)));
        return listResponse;
    }

    private ProductPriceFinderResponse modelToResponse(final ProductPriceModel entity) {
        final ProductPriceFinderResponse response = new ProductPriceFinderResponse();
        response.setProductId(entity.getProductId());
        response.setBrandId(entity.getBrandId());
        response.setPrice(entity.getPrice());
        response.setStartDate(entity.getStartDate());
        response.setEndDate(entity.getEndDate());
        response.setFinalPrice(entity.getPrice());
        return response;
    }

    public List<ProductPriceModel> listFinderQueryEntityToListModel(final List<ProductPriceFinderQuery> dataFound) {
        final List<ProductPriceModel> listModel = new ArrayList<>();
        dataFound.forEach(entity -> listModel.add(finderQueryToModel(entity)));
        return listModel;
    }

    public ProductPriceModel finderQueryToModel(final ProductPriceFinderQuery entity) {
        final ProductPriceModel model = new ProductPriceModel();
        model.setId(entity.getId());
        model.setBrandId(entity.getBrandId());
        model.setStartDate(dataBaseConverter.dateToString(entity.getStartDate()));
        model.setEndDate(dataBaseConverter.dateToString(entity.getEndDate()));
        model.setPriceList(entity.getPriceList());
        model.setProductId(entity.getProductId());
        model.setPriority(entity.getPriority());
        model.setPrice(entity.getPrice());
        model.setCoin(entity.getCoin());
        return model;
    }

    public ProductPriceModel entityToModel(final ProductPriceEntity entity) {
        final ProductPriceModel model = new ProductPriceModel();
        model.setId(entity.getId());
        model.setBrandId(entity.getBrandId());
        model.setStartDate(dataBaseConverter.dateToString(entity.getStartDate()));
        model.setEndDate(dataBaseConverter.dateToString(entity.getEndDate()));
        model.setPriceList(entity.getPriceList());
        model.setProductId(entity.getProductId());
        model.setPriority(entity.getPriority());
        model.setPrice(entity.getPrice());
        model.setCoin(entity.getCoin());
        return model;
    }
}
