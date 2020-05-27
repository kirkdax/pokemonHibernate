package com.raul.pokemon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/*
	Clase Tipo:
		•	Además de los atributos que tiene, debe tenerun campo de pok_pokemon_tipo que será una lista de este tipo y una relacion ONetoMany.
		•	El constructor debe crear la lista a vacia.
		•	Creo un método que sea AddPokemon, recibe como parámetro un pok_pokemon_tipo y lo añade a la lista de pok_pokemon_tipo.
		•	Creo un método que sea DelPokemon, recibe como parámetro un pok_pokemon_tipo y lo borra de la lista de pok_pokemon_tipo.
		•	el ToString de tipo debe mostrar los nombres de los pokemon que tiene.

 */

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
//		return "Pok_tipo [id_tipo=" + id_tipo + ", nombre=" + nombre + "]" + getPokemon();
		return id_tipo + "\t" + nombre + " || --> " + getPokemon();
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
	
	
	public void addPokemon(Pok_pokemon_tipo pokTipo) {
		listaPokemon.add(pokTipo);
	}
	
	public void delPokemon(Pok_pokemon_tipo pokTipo) {
		listaPokemon.add(pokTipo);
	}
	
	
	// método para obtener los pokemon correspondientes a cada tipo
	public String getPokemon() {
		StringBuilder aux = new StringBuilder();
		
		for (Pok_pokemon_tipo pt : listaPokemon) {
			aux.append(pt.getNumero_pokedex().getNombre() + " ");
		}
			
		return aux.toString();
	}
	
		
}
