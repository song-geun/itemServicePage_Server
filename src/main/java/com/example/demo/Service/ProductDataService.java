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
        productDataList = productDataRepository.USP_ProductDataMange("S2","","","","","","");
        return productDataList.isEmpty() ? Collections.emptyList() : productDataList;
    }

    public List<T_product_data> find(String DATE){
        final List<T_product_data> productDataList;
        productDataList = productDataRepository.USP_ProductDataMange("S2","","","","","",DATE);
        return productDataList.isEmpty() ? Collections.emptyList() : productDataList;
    }

    @Transactional
    public void Insert(String Pp,String Pp_id, String Pp_name, String Pvalue, String Pp_quantity, String Pp_DATE)
    {
        productDataRepository.USP_ProductDataMange_I("I1","",Pp_id,Pp_name,Pvalue,Pp_quantity,Pp_DATE);
    }

    @Transactional
    public void DELETE(String DATE) {
        productDataRepository.USP_ProductDataMange_I("D1","","","","","",DATE);
    }
}
