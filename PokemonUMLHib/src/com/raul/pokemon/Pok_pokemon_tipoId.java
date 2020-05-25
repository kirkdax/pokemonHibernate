package com.raul.pokemon;

import java.io.Serializable;


public class Pok_pokemon_tipoId implements Serializable{

	private int id_tipo;
	private int numero_pokedex;
	
	
	
	public Pok_pokemon_tipoId() {
		super();
	}



	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public int getNumero_pokedex() {
		return numero_pokedex;
	}
	public void setNumero_pokedex(int numero_pokedex) {
		this.numero_pokedex = numero_pokedex;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_tipo;
		result = prime * result + numero_pokedex;
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
		Pok_pokemon_tipoId other = (Pok_pokemon_tipoId) obj;
		if (id_tipo != other.id_tipo)
			return false;
		if (numero_pokedex != other.numero_pokedex)
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Pok_pokemon_tipoId [id_tipo=" + id_tipo + ", numero_pokedex=" + numero_pokedex + "]";
	}
		
}
