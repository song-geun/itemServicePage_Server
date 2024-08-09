package com.example.demo.Dto;


import com.example.demo.Entity.T_product_data;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDataDto {
    private final Long prod_data_id;
    private final Long p_id;
    private final String p_name;
    private final Long value;
    private final Long p_quantity;
    private final String DATE;
    public static ProductDataDto from(T_product_data product){
        return ProductDataDto.builder()
                .prod_data_id(product.getProd_data_id())
                .p_id(product.getP_id())
                .p_name(product.getP_name())
                .value(product.getValue())
                .p_quantity(product.getP_quantity())
                .DATE(product.getDATE())
                .build();
    }
}
