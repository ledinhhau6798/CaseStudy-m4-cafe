package com.cg.service.product;

import com.cg.model.Product;
import com.cg.model.dto.product.ProductCreReqDTO;
import com.cg.model.dto.product.ProductCreResDTO;
import com.cg.model.dto.product.ProductResDTO;
import com.cg.model.dto.product.ProductUpReqDTO;
import com.cg.service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<Product,Long> {
    List<ProductResDTO> findAllProductResDTO();
    ProductCreResDTO create(ProductCreReqDTO productCreReqDTO);

    Product update(Product product, ProductUpReqDTO productUpReqDTO);
    void deleteByIdTrue(Long id);
}
