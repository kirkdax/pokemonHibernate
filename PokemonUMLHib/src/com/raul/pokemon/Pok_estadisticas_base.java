package com.raul.pokemon;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pok_estadisticas_base {

	@Id
	private int numero_pokedex;
	private int ps;
	private int ataque;
	private int defensa;
	private int especial;
	private int velocidad;
	
	
	
	public Pok_estadisticas_base() {
		super();
	}
	public Pok_estadisticas_base(int numero_pokedex, int ps, int ataque, int defensa, int especial, int velocidad) {
		super();
		this.numero_pokedex = numero_pokedex;
		this.ps = ps;
		this.ataque = ataque;
		this.defensa = defensa;
		this.especial = especial;
		this.velocidad = velocidad;
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
		return "Pok_estadisticas_base [numero_pokedex=" + numero_pokedex + ", ps=" + ps + ", ataque=" + ataque
				+ ", defensa=" + defensa + ", especial=" + especial + ", velocidad=" + velocidad + "]";
	}
	
	
	public String datosEstadisticas() {
		return numero_pokedex + "\t" + ps + "\t" + ataque + "\t" + defensa;
	}
	
	
}
