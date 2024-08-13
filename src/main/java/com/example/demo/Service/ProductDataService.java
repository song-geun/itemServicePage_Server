package com.example.demo.Service;

import com.example.demo.Entity.T_product_data;
import com.example.demo.Repository.ProductDataRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductDataService {
    private ProductDataRepository productDataRepository;

    @Autowired
    public ProductDataService(ProductDataRepository productDataRepository) {productDataRepository = productDataRepository;}

    public List<T_product_data> findAll(){
        final List<T_product_data> productDataList;
        productDataList = productDataRepository.USP_ProductDataMange("S1","","","","","","");
        return productDataList.isEmpty() ? Collections.emptyList() : productDataList;
    }

    public List<T_product_data> find(String DATE){
        final List<T_product_data> productDataList;
        productDataList = productDataRepository.USP_ProductDataMange("S2","","","","","",DATE);
        return productDataList.isEmpty() ? Collections.emptyList() : productDataList;
    }

    @Transactional
    public String Insert(String Pp_id, String Pp_name, String Pvalue, String Pp_quantity, String Pp_DATE) {
        final List<T_product_data> productDataList;
        productDataList = productDataRepository.USP_ProductDataMange("I1","",Pp_id,Pp_name,Pvalue,Pp_quantity,Pp_DATE);
        return productDataList.isEmpty() ? "Fail" : "OK";
    }

    @Transactional
    public String DELETE(String DATE) {
        if(DATE == "")
            return "Fail";
        final List<T_product_data> productDataList;
        productDataList = productDataRepository.USP_ProductDataMange("D1","","","","","",DATE);
        return productDataList.isEmpty() ? "Fail" : "OK";
    }
}
