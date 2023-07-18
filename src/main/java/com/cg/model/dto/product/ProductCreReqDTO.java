package com.cg.model.dto.product;

import com.cg.model.Category;
import com.cg.model.Product;
import com.cg.model.dto.category.CategoryCreReqDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCreReqDTO {
    private String title;
    private BigDecimal price;
    private Category category;

    public Product toProduct() {
        return new Product()
                .setId(null)
                .setTitle(title)
                .setPrice(price)
                .setCategory(category)
                ;
    }
}
