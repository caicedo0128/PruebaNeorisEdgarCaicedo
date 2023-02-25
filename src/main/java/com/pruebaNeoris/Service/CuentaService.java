package com.pruebaNeoris.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.pruebaNeoris.Entity.Cuenta;
import com.pruebaNeoris.Repository.CuentaRepository;

@Service
public class CuentaService {
	
	@Autowired
	CuentaRepository cuentaRepository;
	
	private final static String MENSAJE_ELIMINAR_OK = "Cuenta Eliminada con Exito";
	private final static String CUENTA_EXISTENTE = "El numero de cuenta ya ha sido asignado";
	
	public ResponseEntity<Object> crearCuenta(Cuenta cuenta){
		Optional<Cuenta> cuentaMovimiento = cuentaRepository.findByNumeroCuenta(cuenta.getNumeroCuenta());
		if(!cuentaMovimiento.isPresent()) {
			Cuenta nuevaCuenta = cuentaRepository.save(cuenta);
			return ResponseEntity.ok().body(nuevaCuenta);
		}else {
			return ResponseEntity.ok().body(CUENTA_EXISTENTE);
		}
		
	}
	
	public ResponseEntity<Object> editarCuenta(Cuenta cuenta){
		Optional<Cuenta> cuentaEditar = cuentaRepository.findById(cuenta.getId());
		Object cuentaEditarObj = new Object();
		if(cuentaEditar.isPresent()) {
			cuentaRepository.save(cuentaEditar.get());
			return ResponseEntity.ok().body(cuentaEditarObj);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cuentaEditarObj);
		}
	}
	
	public ResponseEntity<Object> eliminarCuenta(Cuenta idCuenta){
		Optional<Cuenta> cuentaEliminar = cuentaRepository.findById(idCuenta.getId());		
		if(cuentaEliminar.isPresent()) {
			cuentaRepository.delete(cuentaEliminar.get());
			return ResponseEntity.ok().body(MENSAJE_ELIMINAR_OK);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cuentaEliminar);
		}
	}

}
