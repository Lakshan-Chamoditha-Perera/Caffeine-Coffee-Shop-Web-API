package com.caffeine.center_2.service.custom;

import com.caffeine.center_2.dto.IngredientDto;
import com.caffeine.center_2.service.SuperService;

/**
 * Author: shan
 * Created: 1/20/24 12:03 AM
 */
public interface IngredientService extends SuperService<IngredientDto, String> {
    boolean existsById(String id);
}
