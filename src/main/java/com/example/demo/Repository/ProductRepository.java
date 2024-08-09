package com.example.demo.Repository;

import com.example.demo.Entity.T_product;
import com.example.demo.Entity.T_product_data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<T_product,Long> {
    @Procedure("USP_ProductMange")
    List<T_product_data> USP_ProductMange(@Param());
}
