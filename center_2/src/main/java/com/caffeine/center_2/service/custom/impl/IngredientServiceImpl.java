package com.caffeine.center_2.service.custom.impl;

import com.caffeine.center_2.dao.IngredientRepository;
import com.caffeine.center_2.dto.IngredientDto;
import com.caffeine.center_2.service.custom.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: shan
 * Created: 1/20/24 12:02 AM
 */
@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    @Override
    public IngredientDto save(IngredientDto dto) {

    }

    @Override
    public Boolean update(IngredientDto dto) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }

    @Override
    public IngredientDto findById(String id) {
        return null;
    }

    @Override
    public List<IngredientDto> findAll() {
        return null;
    }
}
