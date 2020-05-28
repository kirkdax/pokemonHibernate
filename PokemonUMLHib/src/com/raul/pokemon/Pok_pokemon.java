package com.raul.pokemon;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
 	Clase Pokemon
		�	Adem�s de los atributos que tenga, tiene que tener un campo que es estad�stica con una relaci�n OnetoOne a Estad�sticas.
		�	Crear un m�todo que sea asingar estad�stica, que llame a crear estad�stica y que introduzca esa estad�stica en el atributo correspondiente. 
			Si ya tiene una estad�stica deber�a dar exception.
		�	Crear un metodo que sea borrar estad�stica, que asigne el campo estad�stica a null.
		�	Crear un m�todo que sea getEstad�stica,, que devuelva la estad�stica
		�	El motodo ToString debe mostrar la estadistica del pokemon.

	Clase Pokemon pero en cuanto a la relaci�n N:M
		�	Adem�s de los atributos que tiene, debe tener un campo de pok_pokemon_tipo que ser� una lista de este tipo y una relaci�n OneToMany.
		�	El constructor debe crear la lista a vacia.
		�	Creo un m�todo que sea AddTipo, recibe como par�metro un pok_pokemon_tipo y lo a�ade a la lista de pok_pokemon_tipo.
		�	Creo un m�todo que sea DelTipo, recibe como par�metro un pok_pokemon_tipo y lo borra de la lista de pok_pokemon_tipo.
		�	el ToString de pokemon debe mostrar los tipos del pokemon.
 */

@Entity
public class Pok_pokemon {

	@Id
	private int numero_pokedex;
	private String nombre;
	private double peso;
	private double altura;
	// Este campo es para unirlo con la tabla Pokemon-Tipo (relacion N:M)
	@OneToMany(mappedBy = "numero_pokedex", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "numero_pokedex")
	private List<Pok_pokemon_tipo> listaPokemon;
	// Este campo es para unirlo con la tabla Estadisticas (relacion 1:N)
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "numero_pokedex")
	private Pok_estadisticas_base Estadistica;
	
	
	
	public Pok_pokemon() {
		super();
		this.listaPokemon = new ArrayList<Pok_pokemon_tipo>();
	}

	public Pok_pokemon(int numero_pokedex, String nombre, double peso, double altura) {
		super();
		this.numero_pokedex = numero_pokedex;
		this.nombre = nombre;
		this.peso = peso;
		this.altura = altura;
		this.listaPokemon = new ArrayList<Pok_pokemon_tipo>();
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
	
	public Pok_estadisticas_base getEstadistica() {
		return Estadistica;
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
		return numero_pokedex + ", nombre=" + nombre + ", peso=" + peso + ", altura=" + altura + " | estad�sticas --> " + getEstadistica() + " | tipo/s --> " + getTipo() ;
	}
	
	
	public String datosPokemon() {
		return numero_pokedex + "\t" + nombre;
	}
	
	
	public void asignarEstadistica(int ps, int ataque, int defensa, int especial, int velocidad) {
		Pok_estadisticas_base nuevasEstadisticas = new Pok_estadisticas_base(this.numero_pokedex, ps, ataque, defensa, especial, velocidad, this);		
		
		Estadistica = nuevasEstadisticas;
	}
    
	
	public void borrarEstadistica() {
		Estadistica = null;
	}
	
	
	public void addTipo(Pok_pokemon_tipo pokTipo) {
		listaPokemon.add(pokTipo);
	}
	
	public void delTipo(Pok_pokemon_tipo pokTipo) {
		listaPokemon.remove(pokTipo);
	}
	
	// m�todo para obtener tipo/s del pokemon
	public String getTipo() {
		StringBuilder aux = new StringBuilder();
		
		for (Pok_pokemon_tipo pt : listaPokemon) {
			aux.append(pt.getId_tipo().getNombre() + " ");
		}
			
		return aux.toString();
	}
	
}
