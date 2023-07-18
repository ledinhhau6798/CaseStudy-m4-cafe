package com.cg.service.product;

import com.cg.model.Category;
import com.cg.model.Product;
import com.cg.model.dto.category.CategoryCreReqDTO;
import com.cg.model.dto.category.CategoryUpReqDTO;
import com.cg.model.dto.product.ProductCreReqDTO;
import com.cg.model.dto.product.ProductCreResDTO;
import com.cg.model.dto.product.ProductResDTO;
import com.cg.model.dto.product.ProductUpReqDTO;
import com.cg.repository.CategoryRepository;
import com.cg.repository.ProductRepository;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<ProductResDTO> findAllProductResDTO() {
        return productRepository.findAllProductResDTO();
    }

    @Override
    public ProductCreResDTO create(ProductCreReqDTO productCreReqDTO) {
        CategoryCreReqDTO categoryCreReqDTO = productCreReqDTO.getCategory();
        Category category =categoryCreReqDTO.toCategory();

        categoryRepository.save(category);
        Product product = productCreReqDTO.toProduct();

        product.setCategory(category);
        productRepository.save(product);

        ProductCreResDTO productCreResDTO = product.toProductCreResDTO();
        return productCreResDTO;
    }

    @Override
    public Product update(Product product, ProductUpReqDTO productUpReqDTO) {
        CategoryUpReqDTO categoryUpReqDTO =productUpReqDTO.getCategory();
        Category category = categoryUpReqDTO.toCategory(product.getCategory().getId());
        categoryRepository.save(category);

        Product productUpdate = productUpReqDTO.toProduct(product.getId(),category);
        productRepository.save(productUpdate);
        return productUpdate;
    }

    @Override
    public void deleteByIdTrue(Long id) {
        productRepository.deleteByIdTrue(id);
    }
}
