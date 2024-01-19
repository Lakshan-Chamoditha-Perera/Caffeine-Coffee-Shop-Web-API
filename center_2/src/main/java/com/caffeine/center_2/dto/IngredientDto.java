package com.caffeine.center_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: shan
 * Created: 1/19/24 11:58 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {
    private String id;
    private String name;
    private String description;
    private Double quantityInStock;
    private Double unitPrice;
    private String status;
    private String added_by;
    private String expire_date;
}
