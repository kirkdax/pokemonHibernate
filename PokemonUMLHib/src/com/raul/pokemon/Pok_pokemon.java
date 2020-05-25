package com.raul.pokemon;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pok_pokemon {

	@Id
	private int numero_pokedex;
	private String nombre;
	private double peso;
	private double altura;
	
	
	
	public Pok_pokemon() {
		super();
	}

	public Pok_pokemon(int numero_pokedex, String nombre, double peso, double altura) {
		super();
		this.numero_pokedex = numero_pokedex;
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
	}

	
	
	public int getNumero_pokedex() {
		return numero_pokedex;
	}
	public void setNumero_pokedex(int numero_pokedex) {
		this.numero_pokedex = numero_pokedex;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Pok_pokemon other = (Pok_pokemon) obj;
		if (numero_pokedex != other.numero_pokedex)
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Pokemon [numero_pokedex=" + numero_pokedex + ", nombre=" + nombre + 
				", peso=" + peso + ", altura=" + altura + "]";
	}
	
//	@Override
//	public String toString() {
//		return numero_pokedex + ", " + nombre + ", peso=" + peso + ", altura=" + altura + "]";
//	}
	
	public String datosPokemon() {
		return numero_pokedex + "\t" + nombre;
	}
    
}
