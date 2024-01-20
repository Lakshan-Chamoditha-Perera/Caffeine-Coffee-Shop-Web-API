package com.caffeine.center_2.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Author: shan
 * Created: 1/19/24 11:58 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {

    private String id;
    @NotNull(message = "Ingredient name is mandatory")
    private String name;

    @NotNull(message = "Ingredient description is mandatory")
    private String description;

    @Positive(message = "Quantity in stock must be positive")
    @NotNull(message = "Ingredient quantity is mandatory")
    private Double quantityInStock;

    @Positive(message = "Unit Price in stock must be positive")
    @NotNull(message = "Unit Price quantity is mandatory")
    private Double unitPrice;

    private String status;

    private String added_by;

    private Date added_date;

    @NotNull(message = "Expire date quantity is mandatory")
    private Date expire_date;

}
