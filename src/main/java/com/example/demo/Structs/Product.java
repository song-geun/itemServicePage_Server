package com.example.demo.Structs;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String p_id = "";
    private String p_name = "";
    private String value = "";
}
