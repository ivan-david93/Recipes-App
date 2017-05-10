package com.app.recipes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.recipes.models.Recipe;

@Transactional
public interface RecipeRepository extends MongoRepository<Recipe, String> {
	
	public Recipe findByNome(String nome);

}
