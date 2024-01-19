package com.caffeine.center_2.dao;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: shan
 * Created: 1/20/24 12:00 AM
 */

@Repository
@EnableMongoRepositories
public interface RecipeRepository extends CrudRepository<RecipeRepository, String> {
}
