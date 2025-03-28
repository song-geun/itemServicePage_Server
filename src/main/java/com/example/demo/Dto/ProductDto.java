package com.example.demo.Dto;


import com.example.demo.Entity.T_product;
import com.example.demo.Entity.T_product_data;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private final Long p_id;
    private final String p_name;
    private final Long value;
    private final Long quantity;
    public static ProductDto from(T_product product){
        return ProductDto.builder()
                .p_id(product.getP_id())
                .p_name(product.getP_name())
                .value(product.getValue())
                .quantity(product.getQuantity())
                .build();
    }
}
