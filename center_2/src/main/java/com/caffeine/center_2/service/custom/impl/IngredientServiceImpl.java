package com.caffeine.center_2.service.custom.impl;

import com.caffeine.center_2.dao.IngredientRepository;
import com.caffeine.center_2.dto.IngredientDto;
import com.caffeine.center_2.entity.Ingredient;
import com.caffeine.center_2.service.custom.IngredientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: shan
 * Created: 1/20/24 12:02 AM
 */
@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final ModelMapper mapper;

    @Override
    public IngredientDto save(IngredientDto dto) throws RuntimeException {
        if (ingredientRepository.existsById(dto.getId())) {
            throw new RuntimeException("Ingredient already exists");
        }
        dto.setAdded_date(Date.valueOf(LocalDate.now()));
        ingredientRepository.save(mapper.map(dto, Ingredient.class));
        return dto;
    }

    @Override
    public Boolean update(IngredientDto dto) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        if (!ingredientRepository.existsById(id)) {
            throw new RuntimeException("No Ingredient for delete..!");
        }
        ingredientRepository.deleteById(id);
        return true;
    }

    @Override
    public IngredientDto findById(String id) {
        return null;
    }

    @Override
    public List<IngredientDto> findAll() {
        List<Ingredient> all = ingredientRepository.findAll();
        return all.stream().map(
                element -> mapper.map(
                        element, IngredientDto.class)
        ).collect(Collectors.toList());
    }


    @Override
    public Boolean existsById(String id) {
        return ingredientRepository.existsById(id);
    }
}
