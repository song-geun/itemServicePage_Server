package com.example.demo.Controller;


import com.example.demo.Dto.ProductDto;
import com.example.demo.Entity.T_product;
import com.example.demo.Service.ProductService;
import com.example.demo.Structs.Product;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok(productService.findAll()
                .stream()
                .map(ProductDto::from)
                .collect(Collectors.toList()));
    }
    @PostMapping("/insertAll")
    @Transactional(rollbackOn = {SQLException.class})
    public void insertAll(@RequestBody List<T_product>  dataAll){
        for(T_product product : dataAll){
            productService.insertProduct(product.getP_id() ,product.getP_name().toString(),product.getValue(), product.getQuantity());
        }
    }
}