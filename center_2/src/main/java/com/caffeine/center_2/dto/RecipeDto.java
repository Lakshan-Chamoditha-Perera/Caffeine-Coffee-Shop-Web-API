package com.caffeine.center_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author: shan
 * Created: 1/19/24 11:55 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
private String id;
    private String name;
    private String description;
    private String category;
    private String status;
    private String added_by;
    private String added_date;
    private List<String> ingredientsList;

}
