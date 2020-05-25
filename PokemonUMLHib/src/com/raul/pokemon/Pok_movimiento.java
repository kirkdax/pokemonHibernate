package com.raul.pokemon;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pok_movimiento {

	@Id
	int id_movimiento;
    String nombre;
    int potencia;
    int precision_mov;
    String descripcion;
    int pp;
    int prioridad;
    int id_tipo;
    
    
	public Pok_movimiento() {
		super();
	}


	public Pok_movimiento(int id_movimiento, String nombre, int potencia, int precision_mov, String descripcion, int pp, int prioridad, int id_tipo) {
		super();
		this.id_movimiento = id_movimiento;
		this.nombre = nombre;
		this.potencia = potencia;
		this.precision_mov = precision_mov;
		this.descripcion = descripcion;
		this.pp = pp;
		this.prioridad = prioridad;
		this.id_tipo = id_tipo;
	}


	public int getId_movimiento() {
		return id_movimiento;
	}


	public void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public int getPrecision_mov() {
		return precision_mov;
	}
	public void setPrecision_mov(int precision_mov) {
		this.precision_mov = precision_mov;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPp() {
		return pp;
	}
	public void setPp(int pp) {
		this.pp = pp;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}


	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_movimiento;
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
		Pok_movimiento other = (Pok_movimiento) obj;
		if (id_movimiento != other.id_movimiento)
			return false;
		return true;
	}


	
	@Override
	public String toString() {
		return "Pok_movimiento [id_movimiento=" + id_movimiento + ", nombre=" + nombre + ", potencia=" + potencia
				+ ", precision_mov=" + precision_mov + ", descripcion=" + descripcion + ", pp=" + pp + ", prioridad="
				+ prioridad + ", id_tipo=" + id_tipo + "]";
	}
	
	
	public String datosMovimiento() {
		return id_movimiento + ", " + nombre + ", " + potencia + ", " + precision_mov + ", " + pp + prioridad;
	}

	
    
}
