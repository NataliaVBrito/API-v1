package com.demo.api.v1.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudad")
public class CiudadEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ciudad")
	private Integer idCiudad;

	private String nombre;

	public CiudadEntity() {
	}

	public CiudadEntity(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public CiudadEntity(Integer idCiudad, String nombre) {
		this.idCiudad = idCiudad;
		this.nombre = nombre;
	}

	public Integer getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ciudad [idCiudad=" + idCiudad + ", nombre=" + nombre + "]";
	}

}
