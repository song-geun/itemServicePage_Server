package com.example.demo.Repository;

import com.example.demo.Entity.T_product_data;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ProductDataRepository extends JpaRepository<T_product_data,Long> {
    @Procedure("USP_ProductDataManage")
    @Transactional(rollbackOn = {SQLException.class})
    List<T_product_data> USP_ProductDataMange(@Param("prstype") String prstype,
                                              @Param("Pprod_data_id") String Pprod_data_id,
                                              @Param("Pp_id") String Pp_id,
                                              @Param("Pp_name") String Pp_name,
                                              @Param("Pvalue") String Pvalue,
                                              @Param("Pp_quantity") String Pp_quantity,
                                              @Param("Pp_DATE") String Pp_DATE);
}
