package com.cg.api;

import com.cg.exception.DataInputException;
import com.cg.model.Product;
import com.cg.model.dto.product.*;
import com.cg.service.product.IProductService;
import com.cg.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductAPI {
    @Autowired
    private IProductService productService;

    @Autowired
    private ValidateUtils validateUtils;

    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        List<ProductResDTO> productResDTO = productService.findAllProductResDTO();
        return new ResponseEntity<>(productResDTO, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getById(@PathVariable Long productId) {
        Product product = productService.findById(productId).orElseThrow(() -> {
            throw new DataInputException("Mã khách hàng không tồn tại");
        });
        ProductResDTO productResDTO = product.toProductResDTO();
        return new ResponseEntity<>(productResDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductCreReqDTO productCreReqDTO) {

        ProductCreResDTO productCreResDTO = productService.create(productCreReqDTO);
        return new ResponseEntity<>(productCreResDTO, HttpStatus.CREATED);
    }

    @PatchMapping("/edit/{productId}")
    public ResponseEntity<?> update(@PathVariable("productId") String productIdStr, @RequestBody ProductUpReqDTO productUpReqDTO) {
        if (!validateUtils.isNumberValid(productIdStr)) {
            Map<String, String> data = new HashMap<>();
            data.put("message", "Mã khách hàng không hợp lệ");
            return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
        }
            Long productId =Long.parseLong(productIdStr);

        Product product =productService.findById(productId).orElseThrow(() -> {
           throw new DataInputException("Mã khách hàng không tồn tại");
        });

        Product productUpdate =productService.update(product,productUpReqDTO);
        ProductUpResDTO productUpResDTO =productUpdate.toProductUpResDTO();

        return new ResponseEntity<>(productUpResDTO,HttpStatus.OK);
    }

    @PatchMapping("/delete/{productId}")
    public ResponseEntity<?> delete(@PathVariable String productId){
        if (!validateUtils.isNumberValid(productId)) {
            throw new DataInputException("Mã khách hàng không hợp lệ");
        }

        productService.deleteByIdTrue(Long.parseLong(productId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
