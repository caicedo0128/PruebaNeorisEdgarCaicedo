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
@Table(name = "cuenta")
@JsonIgnoreProperties(value = { "movimientoList" }, allowSetters = true)
public class Cuenta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "numeroCuenta")
	private Integer numeroCuenta;
	
	@Column(name = "tipoCuenta")
	private String tipoCuenta;
	
	@Column(name = "saldoInicial")
	private Long saldoInicial;
	
	@Column(name = "estado")
	private boolean estado;
	
	@JoinColumn(name = "cliente", referencedColumnName = "clienteId")
	@ManyToOne(optional = false)
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
	private List<Movimiento> movimientoList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Long getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Long saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Movimiento> getMovimientoList() {
		return movimientoList;
	}

	public void setMovimientoList(List<Movimiento> movimientoList) {
		this.movimientoList = movimientoList;
	}
	
	
	

}
