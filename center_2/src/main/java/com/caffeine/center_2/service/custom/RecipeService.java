package com.caffeine.center_2.service.custom;

import com.caffeine.center_2.dto.RecipeDto;
import com.caffeine.center_2.service.SuperService;
import org.springframework.stereotype.Service;

/**
 * Author: shan
 * Created: 1/20/24 12:01 AM
 */
@Service
public interface RecipeService extends SuperService<RecipeDto, String> {
}
