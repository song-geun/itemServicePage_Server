package com.example.demo.Repository;

import com.example.demo.Entity.T_product;
import com.example.demo.Entity.T_product_data;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<T_product, Long> {
    @Procedure("USP_ProductManage")
    @Transactional(rollbackOn = {SQLException.class})
    List<T_product> USP_ProductMange(@Param("prstype") String prstype,
                                     @Param("Pp_id") Long Pp_id,
                                     @Param("Pp_name") String Pp_name,
                                     @Param("P_value") Long P_value,
                                     @Param("P_quantity") Long P_quantity);

    @Procedure("USP_ProductManage")
    @Transactional(rollbackOn = {SQLException.class})
    void USP_ProductMange_I(@Param("prstype") String prstype,
                                     @Param("Pp_id") Long Pp_id,
                                     @Param("Pp_name") String Pp_name,
                                     @Param("P_value") Long P_value,
                                     @Param("P_quantity") Long P_quantity);


}
