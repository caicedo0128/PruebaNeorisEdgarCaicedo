package com.pruebaNeoris.pruebaNeoris;

import java.util.Date;

public class ReporteMovimientoCliente {
	
	private Date fechaInicial;
	private Date fechaFinal;
	private Long cliente;
	
	
	
	public ReporteMovimientoCliente(Date fechaInicial, Date fechaFinal, Long cliente) {
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.cliente = cliente;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	
	

}
