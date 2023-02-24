package com.pruebaNeoris.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pruebaNeoris.Entity.Movimiento;
import com.pruebaNeoris.Repository.MovimientoRepository;

@Service
public class MovimientoService {
	
	@Autowired
	MovimientoRepository movimientoRepository;
	
	private final static String MENSAJE_ELIMINAR_OK = "Movimiento Eliminado con Exito";
	
	public ResponseEntity<Movimiento> crearMovimiento(Movimiento movimiento){
		Movimiento nuevoMovimiento = movimientoRepository.save(movimiento);
		return ResponseEntity.ok().body(nuevoMovimiento);
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
