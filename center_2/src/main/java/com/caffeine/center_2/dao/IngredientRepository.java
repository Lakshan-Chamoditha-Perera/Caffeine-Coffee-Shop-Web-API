package com.caffeine.center_2.dao;

import com.caffeine.center_2.entity.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: shan
 * Created: 1/19/24 11:59 PM
 */

@Repository
@EnableMongoRepositories
public interface IngredientRepository extends MongoRepository<Ingredient, String> {
    boolean existsById(String id);
}
