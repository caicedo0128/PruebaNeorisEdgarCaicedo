package com.pruebaNeoris.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pruebaNeoris.Dto.MovimientosDto;
import com.pruebaNeoris.Entity.Movimiento;
import com.pruebaNeoris.Repository.MovimientoRepository;

@Service
public class ReportesService {
	
	@Autowired
	MovimientoRepository movimientoRepository;
	
	
	public ResponseEntity<List<MovimientosDto>> listarMovimientosByFechaNumeroCuenta(Date fechaInicial, Date fechaFinal, Long clienteId){
		
		List<Movimiento> listadoMovimientos = movimientoRepository.listadoMovimientos(fechaInicial,fechaFinal, clienteId);
		
		List<MovimientosDto> listadoMovimientoDto = new ArrayList<>();
		
		for(Movimiento mov : listadoMovimientos) {
			MovimientosDto movimientoDto = new MovimientosDto();
			movimientoDto.setCliente(mov.getCuenta().getCliente().getPersona().getNombre());
			movimientoDto.setEstado(mov.getCuenta().isEstado());
			movimientoDto.setFecha(mov.getFecha());
			movimientoDto.setNumeroCuenta(mov.getCuenta().getNumeroCuenta());
			movimientoDto.setSaldoDisponible(mov.getCuenta().getSaldoInicial());
			movimientoDto.setTipo(mov.getCuenta().getTipoCuenta());
			movimientoDto.setMovimiento(mov.getValor());
			movimientoDto.setSaldoInicial(mov.getSaldo());
			listadoMovimientoDto.add(movimientoDto);
		}
		
		return ResponseEntity.ok().body(listadoMovimientoDto);
		
	}

}
