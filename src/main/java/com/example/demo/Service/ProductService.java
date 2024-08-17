package com.example.demo.Service;

import com.example.demo.Entity.T_product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Structs.Product;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<T_product> findAll() {
        final List<T_product> products;
        products = (List<T_product>) productRepository.USP_ProductMange("S1", 0L,"",0L, 0L);
        return products.isEmpty() ? Collections.emptyList() : products;
    }
    @Transactional
    public void insertProduct(Long P_id,String P_name, Long Value, Long P_quantity)
    {
        productRepository.USP_ProductMange_I("I1", P_id, P_name, Value, P_quantity);
    }
    @Transactional
    public void updateProduct(Long P_id,String P_name, Long Value, Long P_quantity)
    {
        productRepository.USP_ProductMange_I("U1", P_id, P_name, Value, P_quantity);
    }
    @Transactional
    public void DeleteProduct(Long P_id,String P_name, Long Value, Long P_quantity)
    {
        productRepository.USP_ProductMange_I("D1", P_id, "", 0L, 0L);
    }

}
