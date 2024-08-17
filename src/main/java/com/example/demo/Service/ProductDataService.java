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
    public ProductDataService(ProductDataRepository productDataRepository) {this.productDataRepository = productDataRepository;}

    public List<T_product_data> findAll(){
        final List<T_product_data> productDataList;
        productDataList = productDataRepository.USP_ProductDataMange("S1",0L, 0L,"",0L,0L,"");
        return productDataList.isEmpty() ? Collections.emptyList() : productDataList;
    }

    public List<T_product_data> find(String DATE){
        final List<T_product_data> productDataList;
        productDataList = productDataRepository.USP_ProductDataMange("S2",0L,0L,"",0L,0L,DATE);
        return productDataList.isEmpty() ? Collections.emptyList() : productDataList;
    }

    public List<T_product_data> findmonth(String DATE){
        final List<T_product_data> productDataList;
        productDataList = productDataRepository.USP_ProductDataMange("S3",0L,0L,"",0L,0L,DATE);
        return productDataList.isEmpty() ? Collections.emptyList() : productDataList;
    }

    @Transactional
    public void Insert(String Pp,Long Pp_id, String Pp_name, Long Pvalue, Long Pp_quantity, String Pp_DATE)
    {
        productDataRepository.USP_ProductDataMange_I("I1",0L,Pp_id,Pp_name,Pvalue,Pp_quantity,Pp_DATE);
    }

    @Transactional
    public void DELETE(String DATE) {
        productDataRepository.USP_ProductDataMange_I("D1",0L,0L,"",0L,0L,DATE);
    }
}
