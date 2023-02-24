package com.pruebaNeoris.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaNeoris.Entity.Cliente;
import com.pruebaNeoris.Service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping()
	public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
		return clienteService.crearCliente(cliente);
	}
	
	@PutMapping()
	public ResponseEntity<Object> editarCliente(@RequestBody Cliente cliente){
		return clienteService.editarCliente(cliente);
	}
	
	@DeleteMapping()
	public ResponseEntity<Object> eliminarCliente(@RequestBody Cliente cliente){
		return clienteService.eliminarCliente(cliente);
	}

}
