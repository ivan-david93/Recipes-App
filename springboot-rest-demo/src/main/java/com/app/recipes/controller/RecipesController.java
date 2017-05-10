package com.app.recipes.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.recipes.models.Ingredient;
import com.app.recipes.models.Recipe;
import com.app.recipes.services.RecipesService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/recipes")
public class RecipesController {
	
	@Autowired
	RecipesService recipesService;
	
	
	/**
	 * GET /create --> Create a new recipe and save it in the database.
	 */
	@RequestMapping("/createRecipe")
	public String createRecipe() {
		
		//TODO nota mental quando um documento em mongodb � inserido com mesmo id substitui o existente ter muito cuidado nas validacoes
		
		System.out.println("entrou create receita controller ");
		String preparacao = "Comece por cortar a carne de porco aos cubos e tempere-os com a Vaqueiro Ideal para Porco e uma pitada de sal. Envolva tudo muito bem e regue o preparado com vinho branco deixando marinar durante algumas horas ou, de prefer�ncia, de um dia para o outro. Findo esse tempo, retire a carne da marinada, reservando-a e leve a carne a cozinhar numa frigideira com Vaqueiro Ideal para Porco, at� ficar a seu gosto. Junte a marinada que reservou e deixe a carne cozinhar mais um pouco. Adicione as am�ijoas previamente lavadas e deixe cozinhar mais uns minutos para que abram e ganhem sabor. Rectifique os temperos, caso seja necess�rio. Na hora de servir, junte � carne as batatas aos cubos previamente fritas, os pickles (opcional) e polvilhe tudo com salsa picada. Sirva quente." ;
		String tempoMedio = "5 min" ;
		String nome= "Carne de Porco Alentejana";
		Integer dificuldade = 3;
		String media = "url imagem";
		
		Date createDate = new Date();
		List<Ingredient> ingredientes = new ArrayList<Ingredient>() ;
		
		Ingredient firstIngrediente = new Ingredient("LOMBO DE PORCO", "1Kg");
		Ingredient secondIngrediente = new Ingredient("VAQUEIRO IDEAL PARA PORCO", "3");
		Ingredient thirdIngrediente = new Ingredient("VINHO BRANCO", "QB");
		
		Ingredient ingredientCreated1 = recipesService.createIngredient(firstIngrediente);
		Ingredient ingredientCreated2 = recipesService.createIngredient(secondIngrediente);
		Ingredient ingredientCreated3 = recipesService.createIngredient(thirdIngrediente);
		
		ingredientes.add(ingredientCreated1);
		ingredientes.add(ingredientCreated2);
		ingredientes.add(ingredientCreated3);
		
		
		
//		String id = "fbfb545";
		
		Recipe newRecipe = new Recipe( media, dificuldade, tempoMedio, nome, preparacao, ingredientes, createDate);
		
		Recipe recipeCreated = recipesService.createRecipe(newRecipe);
		Gson gson = new Gson();

		// 1. Java object to JSON, and save into a file
		String json = gson.toJson(recipeCreated);
		return json;
		
	}
	
	
	

	/**
	 * GET /create --> Create a new recipe and save it in the database.
	 */
	@RequestMapping("/createIngredient")
	public String createIngredient() {
		
		//TODO nota mental quando um documento em mongodb � inserido com mesmo id substitui o existente ter muito cuidado nas validacoes
		
		System.out.println("entrou create ingredient controller ");
		
		Ingredient ingredient = new Ingredient("Peito de perú", "1Kg");
		Ingredient ingredientDB = recipesService.createIngredient(ingredient);
		

		Gson gson = new Gson();

		// 1. Java object to JSON, and save into a file
		String json = gson.toJson(ingredientDB);
		return json;
		
	}

	/**
	 * GET /read --> Read a recipe by recipe id from the database.
	 */
	@RequestMapping("/read")
	public String read(@RequestParam String nome) {
		
		System.out.println("Entrou controlador find by nome");
		
		Recipe recipe = recipesService.findByNome(nome);
		Gson gson = new Gson();

		// 1. Java object to JSON, and save into a file
		String json = gson.toJson(recipe);
		return json;
	}
//
//	/**
//	 * GET /update --> Update a recipe record and save it in the database.
//	 */
//	@RequestMapping("/update")
//	public Map<String, Object> update(@RequestParam String recipeId, @RequestParam String psngrName) {
//		return dataMap;
//	}
//
//	/**
//	 * GET /delete --> Delete a recipe from the database.
//	 */
//	@RequestMapping("/delete")
//	public Map<String, Object> delete(@RequestParam String recipeId) {
//		return dataMap;
//	}
//
	/**
	 * GET /read --> Read all recipe from the database.
	 */
	@RequestMapping("/read-all")
	public String readAll() {
		
		System.out.println("Entrou controlador findAll");
		
		List<Recipe> recipes = recipesService.findAll();
		
		Gson gson = new Gson();

		// 1. Java object to JSON, and save into a file
		String json = gson.toJson(recipes);
		
		return json;
	}

}
