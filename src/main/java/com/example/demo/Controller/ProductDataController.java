package com.example.demo.Controller;

import com.example.demo.Dto.ProductDataDto;
import com.example.demo.Dto.ProductDto;
import com.example.demo.Entity.T_product;
import com.example.demo.Entity.T_product_data;
import com.example.demo.Service.ProductDataService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ProductData")
public class ProductDataController {
    private final ProductDataService productDataService;

    public ProductDataController(ProductDataService productDataService) {this.productDataService = productDataService;}

    @GetMapping("/list")
    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<List<ProductDataDto>> findAll(){
        return ResponseEntity.ok(productDataService.findAll()
                .stream()
                .map(ProductDataDto::from)
                .collect(Collectors.toList()));
    }
    @PostMapping("/datelist")
    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<List<ProductDataDto>> find(@RequestBody T_product_data date){
        ResponseEntity<List<ProductDataDto>> result =
         ResponseEntity.ok(productDataService.find(date.getDATE())
                .stream()
                .map(ProductDataDto::from)
                .collect(Collectors.toList()));
        return result;
    }

    @PostMapping("/monthlist")
    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<List<ProductDataDto>> findmonth(@RequestBody T_product_data date){
        ResponseEntity<List<ProductDataDto>> result =
                ResponseEntity.ok(productDataService.findmonth(date.getDATE())
                        .stream()
                        .map(ProductDataDto::from)
                        .collect(Collectors.toList()));
        return result;
    }
    @PostMapping("/periodlist")
    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<List<ProductDataDto>> findperiod(@RequestBody T_product_data date){
        ResponseEntity<List<ProductDataDto>> result =
                ResponseEntity.ok(productDataService.findPeriod(date.getP_name(),date.getDATE())
                        .stream()
                        .map(ProductDataDto::from)
                        .collect(Collectors.toList()));
        return result;
    }


    @PostMapping("/insertAll")
    @Transactional(rollbackOn = {SQLException.class})
    public void insertAll(@RequestBody List<T_product_data>  dataAll){
        for(T_product_data product : dataAll)
        {
            productDataService.Insert(product.getProd_data_id().toString(),product.getP_id(),product.getP_name(),
                    product.getValue(),product.getP_quantity(),product.getDATE());
        }
    }
    @PostMapping("/insert")
    @Transactional(rollbackOn = {SQLException.class})
    public void insertAll(@RequestBody T_product_data  product){
            productDataService.Insert(product.getProd_data_id().toString(),product.getP_id(),product.getP_name(),
                    product.getValue(),product.getP_quantity(),product.getDATE());
    }
}
