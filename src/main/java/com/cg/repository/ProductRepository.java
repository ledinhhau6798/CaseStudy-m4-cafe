package com.cg.repository;

import com.cg.model.Product;
import com.cg.model.dto.product.ProductResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT NEW com.cg.model.dto.product.ProductResDTO (" +
            "pro.id," +
            "pro.title," +
            "pro.price," +
            "pro.category" +
            ")" +
            "FROM Product as pro " +
            "WHERE pro.deleted = false"
    )
    List<ProductResDTO>findAllProductResDTO();

    @Modifying
    @Transactional
    @Query("UPDATE Product p " +
            "SET p.deleted = TRUE " +
            "WHERE p.id = :id")
    void deleteByIdTrue(@Param("id") long id);
}
