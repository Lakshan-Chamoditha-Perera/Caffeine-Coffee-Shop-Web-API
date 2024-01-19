package com.caffeine.center_2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Author: shan
 * Created: 1/19/24 11:13 PM
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private String id;
    private String name;
    private String description;
    private String category;
    private Date added_date;
    private String added_by;
    private String status;
    private List<Ingredient> ingredientsList;
}
