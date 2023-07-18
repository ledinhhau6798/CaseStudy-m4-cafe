package com.cg.model.dto.product;

import com.cg.model.Category;
import com.cg.model.dto.category.CategoryDTO;
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
public class ProductResDTO {

    private Long id;
    private String title;
    private BigDecimal price;
    private CategoryDTO category;

    public ProductResDTO(Long id,String title,BigDecimal price,Category category){
        this.id=id;
        this.title=title;
        this.price=price;
        this.category = category.toCategoryDTO();
    }
}
