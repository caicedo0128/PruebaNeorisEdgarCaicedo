package com.pruebaNeoris.pruebaNeoris;

import com.pruebaNeoris.Entity.Cliente;

public class CuentaTest {
	
	private Integer numeroCuenta;
	
	private String tipoCuenta;
	
	private Long saldoInicial;
	
	private boolean estado;
	
	private Cliente cliente;

	public CuentaTest(Integer numeroCuenta, String tipoCuenta, Long saldoInicial, boolean estado, Cliente cliente) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.tipoCuenta = tipoCuenta;
		this.saldoInicial = saldoInicial;
		this.estado = estado;
		this.cliente = cliente;
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
	
	
	

}
