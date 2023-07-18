package com.cg.model.dto.product;
import com.cg.model.Category;
import com.cg.model.Product;
import com.cg.model.dto.category.CategoryUpReqDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductUpReqDTO {
    private String title;
    private BigDecimal price;
    private CategoryUpReqDTO category;

    public Product toProduct(Long productId, Category category) {
        return new Product()
                .setId(productId)
                .setTitle(title)
                .setPrice(price)
                .setCategory(category)
                ;
    }
}
