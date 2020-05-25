package com.raul.pokemon;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(Pok_pokemon_tipoId.class)
public class Pok_pokemon_tipo implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="id_tipo", insertable = false, updatable = false )
	private Pok_tipo id_tipo;
	@Id
	@ManyToOne
	@JoinColumn(name="numero_pokedex", insertable = false, updatable = false )
	private Pok_pokemon numero_pokedex;
	
	
	
	public Pok_pokemon_tipo() {
		super();
	}
	
	public Pok_pokemon_tipo(Pok_tipo id_tipo, Pok_pokemon numero_pokedex) {
		super();
		this.id_tipo = id_tipo;
		this.numero_pokedex = numero_pokedex;
	}
	

	
	public Pok_tipo getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Pok_tipo id_tipo) {
		this.id_tipo = id_tipo;
	}

	public Pok_pokemon getNumero_pokedex() {
		return numero_pokedex;
	}

	public void setNumero_pokedex(Pok_pokemon numero_pokedex) {
		this.numero_pokedex = numero_pokedex;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_tipo == null) ? 0 : id_tipo.hashCode());
		result = prime * result + ((numero_pokedex == null) ? 0 : numero_pokedex.hashCode());
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
		Pok_pokemon_tipo other = (Pok_pokemon_tipo) obj;
		if (id_tipo == null) {
			if (other.id_tipo != null)
				return false;
		} else if (!id_tipo.equals(other.id_tipo))
			return false;
		if (numero_pokedex == null) {
			if (other.numero_pokedex != null)
				return false;
		} else if (!numero_pokedex.equals(other.numero_pokedex))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Pok_pokemon_tipo [id_tipo=" + id_tipo + ", numero_pokedex=" + numero_pokedex + "]";
	}

	
	
}
