package com.caffeine.center_2.dao;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: shan
 * Created: 1/19/24 11:59 PM
 */

@Repository
@EnableMongoRepositories
public interface IngredientRepository extends CrudRepository<IngredientRepository, String> {
}