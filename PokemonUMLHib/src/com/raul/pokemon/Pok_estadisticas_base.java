package com.raul.pokemon;

/*
  	Clases Estadística
		•	Ademas de los atriabutos tiene un campo que es pockemon con una relacion onetoOne a pokemon.
		•	Tienes que modificar el ToString de estadistica para que te permita ver el nombre del pokemon junto con el resto de los atributos

 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Pok_estadisticas_base {

	@Id
	private int numero_pokedex;
	private int ps;
	private int ataque;
	private int defensa;
	private int especial;
	private int velocidad;
	@OneToOne	
	@JoinColumn(name = "numero_pokedex")
	private Pok_pokemon Pokemon;
	
	
	public Pok_estadisticas_base() {
		super();
	}
	public Pok_estadisticas_base(int numero_pokedex, int ps, int ataque, int defensa, int especial, int velocidad, Pok_pokemon Pokemon) {
		super();
		this.numero_pokedex = numero_pokedex;
		this.ps = ps;
		this.ataque = ataque;
		this.defensa = defensa;
		this.especial = especial;
		this.velocidad = velocidad;
		this.Pokemon = Pokemon;
	}
	
	
	
	public int getNumero_pokedex() {
		return numero_pokedex;
	}
	public void setNumero_pokedex(int numero_pokedex) {
		this.numero_pokedex = numero_pokedex;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getEspecial() {
		return especial;
	}
	public void setEspecial(int especial) {
		this.especial = especial;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
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
		Pok_estadisticas_base other = (Pok_estadisticas_base) obj;
		if (numero_pokedex != other.numero_pokedex)
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
//		return Pokemon.getNombre() + " --> [PS=" + ps + ", Ataque=" + ataque + ", Defensa=" + defensa + ", Especial=" + especial + ", Velocidad=" + velocidad + "]";
		return "[" + Pokemon.getNumero_pokedex() + "] PS=" + ps + ", Ataque=" + ataque + ", Defensa=" + defensa + ", Especial=" + especial + ", Velocidad=" + velocidad;
	}
	
	
	public String datosEstadisticas() {
		return numero_pokedex + "\t" + ps + "\t" + ataque + "\t" + defensa;
	}
	

	
}
