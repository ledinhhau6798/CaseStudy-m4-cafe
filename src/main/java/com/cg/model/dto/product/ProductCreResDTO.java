package com.cg.model.dto.product;

import com.cg.model.dto.category.CategoryCreResDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class ProductCreResDTO {
    private Long id;
     private String title;
    private BigDecimal price;
    private CategoryCreResDTO category;
}
