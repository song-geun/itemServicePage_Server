package com.example.demo.Repository;

import com.example.demo.Entity.T_product_data;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDataRepository extends JpaRepository<T_product_data,Long> {
    @Procedure("USP_ProductDataManage")
    @Transactional
    List<T_product_data> USP_ProductDataMange(@Param("prstype") String prstype,
                                              @Param("Pprod_data_id") Long Pprod_data_id,
                                              @Param("Pp_id") Long Pp_id,
                                              @Param("Pp_name") String Pp_name,
                                              @Param("Pvalue") Long Pvalue,
                                              @Param("Pp_quantity") Long Pp_quantity,
                                              @Param("Pp_DATE") String Pp_DATE);
    @Procedure("USP_ProductDataManage")
    @Transactional
    void USP_ProductDataMange_I(@Param("prstype") String prstype,
                                              @Param("Pprod_data_id") Long Pprod_data_id,
                                              @Param("Pp_id") Long Pp_id,
                                              @Param("Pp_name") String Pp_name,
                                              @Param("Pvalue") Long Pvalue,
                                              @Param("Pp_quantity") Long Pp_quantity,
                                              @Param("Pp_DATE") String Pp_DATE);

    @Procedure("USP_ProductDataManage2")
    @Transactional
    List<T_product_data> USP_ProductDataMange_T(@Param("prstype") String prstype,
                                @Param("Pprod_data_id") Long Pprod_data_id,
                                @Param("Pp_id") Long Pp_id,
                                @Param("Pp_name") String Pp_name,
                                @Param("Pvalue") Long Pvalue,
                                @Param("Pp_quantity") Long Pp_quantity,
                                @Param("Pp_DATE1") String Pp_DATE1,
                                @Param("Pp_DATE2") String Pp_DATE2
                                );
}
