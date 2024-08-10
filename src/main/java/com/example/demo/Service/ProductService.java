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
        products = (List<T_product>) productRepository.USP_ProductMange("S1","","","");
        return products.isEmpty() ? Collections.emptyList() : products;
    }
    @Transactional
    public List<T_product> insertProduct(Product product)
    {
        final List<T_product> products;
        products = productRepository.USP_ProductMange("I1", product.getP_id(), product.getP_name(), product.getValue());
        return products.isEmpty() ? Collections.emptyList() : products;
    }

    @Transactional
    public List<T_product> updateProduct(Product product)
    {
        final List<T_product> products;
        products = productRepository.USP_ProductMange("U1", product.getP_id(), product.getP_name(), product.getValue());
        return products.isEmpty() ? Collections.emptyList() : products;
    }
}
