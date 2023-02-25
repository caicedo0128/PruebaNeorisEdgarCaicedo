package com.pruebaNeoris.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MovimientosDto {
	
	private Date fecha;
	
	private String cliente;
	
	private Integer numeroCuenta;
	
	private String tipo;
	
	private Long saldoInicial;
	
	private boolean estado;
	
	private Long movimiento;
	
	private Long saldoDisponible;

	@JsonFormat(pattern="dd/MM/yyyy")
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public Long getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Long movimiento) {
		this.movimiento = movimiento;
	}

	public Long getSaldoDisponible() {
		return saldoDisponible;
	}

	public void setSaldoDisponible(Long saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}

}
