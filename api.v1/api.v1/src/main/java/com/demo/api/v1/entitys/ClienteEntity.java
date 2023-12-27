package com.demo.api.v1.entitys;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cliente")
	private Integer idCliente;

	private String nombre;
	private String apellido;
	private String domicilio;
	private String email;
	private String contrasenia;

	@JoinColumn(name = "id_ciudad")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private CiudadEntity idCiudad;

	private boolean habilitado;

	public ClienteEntity() {
		super();
	}

	public ClienteEntity(Integer idCliente, String nombre, String apellido, String domicilio, String email,
			String contrasenia, CiudadEntity idCiudad, boolean habilitado) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.email = email;
		this.contrasenia = contrasenia;
		this.idCiudad = idCiudad;
		this.habilitado = habilitado;
	}

	public ClienteEntity(String nombre, String apellido, String domicilio, CiudadEntity idCiudad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.idCiudad = idCiudad;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public CiudadEntity getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(CiudadEntity idCiudad) {
		this.idCiudad = idCiudad;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	@Override
	public String toString() {
		return "ClienteEntity [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", domicilio=" + domicilio + ", email=" + email + ", contrasenia=" + contrasenia + ", idCiudad="
				+ idCiudad + ", habilitado=" + habilitado + "]";
	}

}
