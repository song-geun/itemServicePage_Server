package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class T_product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;
    @Column
    private String p_name;
    @Column
    private Long value;
}