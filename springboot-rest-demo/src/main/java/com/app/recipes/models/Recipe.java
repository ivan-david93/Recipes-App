package com.app.recipes.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Recipe {

	@Id
	String id;

	Avaliacao avaliacao;

	String media;

	Integer dificuldade;

	String tempoMedio;

	String nome;

	String preparacao;

	List<Ingredient> ingredientes;

	Date createDate;

	Date updateDate;
	
	
	public Recipe() {
		
	}
	
	
	public Recipe( String media, int dificuldade, String tempoMedio, String nome,
			String preparacao, List<Ingredient> ingredientes, Date createDate) {
		super();
		this.media = media;
		this.dificuldade = dificuldade;
		this.tempoMedio = tempoMedio;
		this.nome = nome;
		this.preparacao = preparacao;
		this.ingredientes = ingredientes;
		this.createDate = createDate;
	}


	public Recipe( Avaliacao avaliacao, String media, int dificuldade, String tempoMedio, String nome,
			String preparacao, List<Ingredient> ingredientes, Date createDate, Date updateDate) {
		super();
		this.avaliacao = avaliacao;
		this.media = media;
		this.dificuldade = dificuldade;
		this.tempoMedio = tempoMedio;
		this.nome = nome;
		this.preparacao = preparacao;
		this.ingredientes = ingredientes;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public Avaliacao getAvaliacao() {
		return avaliacao;
	}




	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}




	public String getMedia() {
		return media;
	}




	public void setMedia(String media) {
		this.media = media;
	}




	public int getDificuldade() {
		return dificuldade;
	}




	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}




	public String getTempoMedio() {
		return tempoMedio;
	}




	public void setTempoMedio(String tempoMedio) {
		this.tempoMedio = tempoMedio;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getPreparacao() {
		return preparacao;
	}




	public void setPreparacao(String preparacao) {
		this.preparacao = preparacao;
	}




	public List<Ingredient> getIngredientes() {
		return ingredientes;
	}




	public void setIngredientes(List<Ingredient> ingredientes) {
		this.ingredientes = ingredientes;
	}




	public Date getCreateDate() {
		return createDate;
	}




	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}




	public Date getUpdateDate() {
		return updateDate;
	}




	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}




	class Avaliacao {

		private int avaliacao;

		private int nro_avaliacoes;
		
		

		public Avaliacao(int avaliacao, int nro_avaliacoes) {
			super();
			this.avaliacao = avaliacao;
			this.nro_avaliacoes = nro_avaliacoes;
		}

		public int getAvaliacao() {
			return avaliacao;
		}

		public void setAvaliacao(int avaliacao) {
			this.avaliacao = avaliacao;
		}

		public int getNro_avaliacoes() {
			return nro_avaliacoes;
		}

		public void setNro_avaliacoes(int nro_avaliacoes) {
			this.nro_avaliacoes = nro_avaliacoes;
		}

	}

}
