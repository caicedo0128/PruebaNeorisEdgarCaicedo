package com.pruebaNeoris.Service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pruebaNeoris.Entity.Cuenta;
import com.pruebaNeoris.Entity.Movimiento;
import com.pruebaNeoris.Repository.CuentaRepository;
import com.pruebaNeoris.Repository.MovimientoRepository;

@Service
public class MovimientoService {
	
	@Autowired
	MovimientoRepository movimientoRepository;
	
	@Autowired
	CuentaRepository cuentaRepository;
	
	private final static String MENSAJE_ELIMINAR_OK = "Movimiento Eliminado con Exito";
	private final static String MOVIMIENTO_DEBITO = "Retiro";
	private final static String MOVIMIENTO_CREDITO = "Deposito";
	private final static String MOVIMIENTO_PERMITIDO = "Movimiento permitido";
	private final static String MENSAJE_MOVIMIENTO_NO_PERMITIDO = "Tipo de movimiento no permitido";
	private final static String MENSAJE_SALDO_NO_DISPONIBLE = "Saldo no disponible";
	
	
	public ResponseEntity<Object> crearMovimiento(Movimiento movimiento){
		Optional<Cuenta> cuentaMovimiento = cuentaRepository.findByNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());
		movimiento.setSaldo(cuentaMovimiento.get().getSaldoInicial());
		if(cuentaMovimiento.isPresent()) {
			HashMap<String, Cuenta> cuentaResponse = validarSaldoDisponible(cuentaMovimiento.get(), movimiento);
			if(cuentaResponse.containsKey(MENSAJE_SALDO_NO_DISPONIBLE)) {
				return ResponseEntity.ok().body(MENSAJE_SALDO_NO_DISPONIBLE);
			}else {
				movimiento.setCuenta(cuentaResponse.get(MOVIMIENTO_PERMITIDO));
				
			}
			movimiento = movimientoRepository.save(movimiento);
		}
		return ResponseEntity.ok().body(movimiento);
	}
	
	private HashMap<String, Cuenta> validarSaldoDisponible(Cuenta cuentaMovimiento, Movimiento movimiento) {
		HashMap<String, Cuenta> cuentaResponse = new HashMap<String,Cuenta>();
		if(movimiento.getTipoMovimiento().equals(MOVIMIENTO_CREDITO)) {
			cuentaMovimiento.setSaldoInicial(cuentaMovimiento.getSaldoInicial() + movimiento.getValor());
			cuentaResponse.put(MOVIMIENTO_PERMITIDO, cuentaMovimiento);
			cuentaRepository.save(cuentaMovimiento);
			return cuentaResponse;
		}else if(movimiento.getTipoMovimiento().equals(MOVIMIENTO_DEBITO)) {
			if(cuentaMovimiento.getSaldoInicial() >= movimiento.getValor()) {
				cuentaMovimiento.setSaldoInicial(cuentaMovimiento.getSaldoInicial() - movimiento.getValor());
				cuentaResponse.put(MOVIMIENTO_PERMITIDO, cuentaMovimiento);
				cuentaRepository.save(cuentaMovimiento);
				return cuentaResponse;
			}else {
				cuentaResponse.put(MENSAJE_SALDO_NO_DISPONIBLE, cuentaMovimiento);
				return cuentaResponse;
			}
		}else {
			cuentaResponse.put(MENSAJE_MOVIMIENTO_NO_PERMITIDO, cuentaMovimiento);
			return cuentaResponse;
		}
	}
	
	public ResponseEntity<Object> editarMovimiento(Movimiento movimiento){
		Optional<Movimiento> movimientoEditar = movimientoRepository.findById(movimiento.getId());
		Object movimientoEditarObj = new Object();
		if(movimientoEditar.isPresent()) {
			movimientoEditarObj = movimientoEditar.get();
			return ResponseEntity.ok().body(movimientoEditarObj);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(movimientoEditarObj);
		}
	}
	
	public ResponseEntity<Object> eliminarMovimiento(Movimiento idMovimiento){
		Optional<Movimiento> movimientoEliminar = movimientoRepository.findById(idMovimiento.getId());		
		if(movimientoEliminar.isPresent()) {
			movimientoRepository.delete(movimientoEliminar.get());
			return ResponseEntity.ok().body(MENSAJE_ELIMINAR_OK);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(movimientoEliminar);
		}
	}

}
