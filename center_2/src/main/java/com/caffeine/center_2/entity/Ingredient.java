package com.caffeine.center_2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Author: shan
 * Created: 1/19/24 11:51 PM
 */
@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {
    private String id;
    private String name;
    private String description;
    private Double quantityInStock;
    private Double unitPrice;
    private String status;
    private Date added_date;
    private String added_by;
    private Date expire_date;
}
