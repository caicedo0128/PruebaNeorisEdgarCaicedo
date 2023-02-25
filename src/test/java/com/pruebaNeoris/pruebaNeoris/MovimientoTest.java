package com.pruebaNeoris.pruebaNeoris;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pruebaNeoris.Entity.Cuenta;

public class MovimientoTest {
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date fecha;
	
	private String tipoMovimiento;
	
	private Long valor;
	
	private Cuenta cuenta;

	public MovimientoTest(Date fecha, String tipoMovimiento, Long valor, Cuenta cuenta) {
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.valor = valor;
		this.cuenta = cuenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	

}
