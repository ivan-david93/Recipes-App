package com.app.recipes.services;

import java.util.List;

import com.app.recipes.models.Ingredient;
import com.app.recipes.models.Recipe;

public interface RecipesService {

	Recipe createRecipe(Recipe recipe);

	List<Recipe> findAll();

	Recipe findByNome(String nome);

	Ingredient createIngredient(Ingredient firstIngrediente);

}
