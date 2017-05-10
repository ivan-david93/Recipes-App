package com.app.recipes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.recipes.models.Ingredient;

@Transactional
public interface IngredientRepository extends MongoRepository<Ingredient, String>{

}
