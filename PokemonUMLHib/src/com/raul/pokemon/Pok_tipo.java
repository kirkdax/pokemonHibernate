package com.raul.pokemon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Pok_tipo implements Serializable {

	@Id
	private int id_tipo;
	private String nombre;
	@OneToMany
	@JoinColumn(name = "id_tipo")
	private List<Pok_pokemon_tipo> listaPokemon;
	
	
	public Pok_tipo() {
		super();
		this.listaPokemon = new ArrayList<Pok_pokemon_tipo>();
	}
	
	public Pok_tipo(int id_tipo) {
		super();
		this.id_tipo = id_tipo;
		this.listaPokemon = new ArrayList<Pok_pokemon_tipo>();
	}
	
	public Pok_tipo(int id_tipo, String nombre) {
		super();
		this.id_tipo = id_tipo;
		this.nombre = nombre;
		this.listaPokemon = new ArrayList<Pok_pokemon_tipo>();
	}

	
	
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_tipo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pok_tipo other = (Pok_tipo) obj;
		if (id_tipo != other.id_tipo)
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Pok_tipo [id_tipo=" + id_tipo + ", nombre=" + nombre + "]";
	}
	
	
	
	public String datosTipo() {
		return id_tipo + "\t" + nombre;
	}
	
	
	public String getListaPokemon() {
		StringBuilder aux = new StringBuilder();
		
		for (Pok_pokemon_tipo pokTipo : listaPokemon) {
			aux.append(pokTipo.getNumero_pokedex().datosPokemon() + "\n");
		}
		
		return aux.toString();
	}
	
	
	public void addPokemon(Pok_pokemon newPokemon) {
		
	}
	
}
