package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class T_product_data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prod_data_id;
    @Column
    private Long p_id;
    @Column
    private String p_name;
    @Column
    private Long value;
    @Column
    private Long p_quantity;
    @Column
    private String DATE;
}