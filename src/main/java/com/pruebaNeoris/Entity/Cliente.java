package com.pruebaNeoris.Entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
@JsonIgnoreProperties(value = { "cuentaList" }, allowSetters = true)
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clienteId")
	private Long clienteId;
	
	@JoinColumn(name = "persona", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Persona persona;
	
	@Column(name = "contraseña")
	private String contraseña;
	
	@Column(name = "estado")
	private String estado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Cuenta> cuentaList;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Cuenta> getCuentaList() {
		return cuentaList;
	}

	public void setCuentaList(List<Cuenta> cuentaList) {
		this.cuentaList = cuentaList;
	}
	
	

}
