package com.app.recipes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.recipes.models.Ingredient;
import com.app.recipes.models.Recipe;
import com.app.recipes.repository.IngredientRepository;
import com.app.recipes.repository.RecipeRepository;
import com.app.recipes.services.RecipesService;


@Service
public class RecipesServiceImpl implements RecipesService {
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	

	public Recipe createRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		
		Recipe recipeNew = recipeRepository.save(recipe);
		if (recipeNew  != null) {
			return recipeNew;
		}
		return null;
	}

	public List<Recipe> findAll() {
		// TODO Auto-generated method stub
		
		List<Recipe> recipes = recipeRepository.findAll();
		return recipes;
	}

	public Recipe findByNome(String nome) {
		// TODO Auto-generated method stub
		Recipe recipe = recipeRepository.findByNome(nome);
		return recipe;
	}

	public Ingredient createIngredient(Ingredient ingredient) {
		// TODO Auto-generated method stub
		
		Ingredient ingredientNew = ingredientRepository.save(ingredient);
		if (ingredientNew  != null) {
			return ingredientNew;
		}
		return null;
	}

}
