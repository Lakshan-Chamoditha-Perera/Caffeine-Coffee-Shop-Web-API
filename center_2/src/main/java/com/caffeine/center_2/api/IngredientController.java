package com.caffeine.center_2.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: shan
 * Created: 1/20/24 12:11 AM
 */
@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    @GetMapping
    public String getIngredient() {
        return "ingredient";
    }

    @PostMapping
    public String postIngredient() {
        return "ingredient";
    }
}
