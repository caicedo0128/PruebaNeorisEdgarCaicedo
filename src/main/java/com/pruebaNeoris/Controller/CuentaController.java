package com.pruebaNeoris.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaNeoris.Entity.Cuenta;
import com.pruebaNeoris.Service.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@PostMapping()
	public ResponseEntity<Object> crearCuenta(@RequestBody Cuenta cuenta){
		return cuentaService.crearCuenta(cuenta);
	}
	
	@PutMapping()
	public ResponseEntity<Object> editarCuenta(@RequestBody Cuenta cuenta){
		return cuentaService.editarCuenta(cuenta);
	}
	
	@DeleteMapping()
	public ResponseEntity<Object> eliminarCuenta(@RequestBody Cuenta cuenta){
		return cuentaService.eliminarCuenta(cuenta);
	}

}
