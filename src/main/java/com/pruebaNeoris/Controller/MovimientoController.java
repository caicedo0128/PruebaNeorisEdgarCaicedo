package com.pruebaNeoris.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaNeoris.Entity.Movimiento;
import com.pruebaNeoris.Service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
	
	@Autowired
	MovimientoService movimientoService;
	
	@PostMapping()
	public ResponseEntity<Movimiento> crearMovimiento(@RequestBody Movimiento movimiento){
		return movimientoService.crearMovimiento(movimiento);
	}
	
	@PutMapping()
	public ResponseEntity<Object> editarMovimiento(@RequestBody Movimiento movimiento){
		return movimientoService.editarMovimiento(movimiento);
	}
	
	@DeleteMapping()
	public ResponseEntity<Object> eliminarMovimiento(@RequestBody Movimiento movimiento){
		return movimientoService.eliminarMovimiento(movimiento);
	}

}
