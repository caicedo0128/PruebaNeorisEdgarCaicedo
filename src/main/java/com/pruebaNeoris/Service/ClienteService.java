package com.pruebaNeoris.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pruebaNeoris.Entity.Cliente;
import com.pruebaNeoris.Repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	private final static String MENSAJE_ELIMINAR_OK = "Cliente Eliminado con Exito";
	
	public ResponseEntity<Cliente> crearCliente(Cliente cliente){
		Cliente nuevoCliente = clienteRepository.save(cliente);
		return ResponseEntity.ok().body(nuevoCliente);
	}
	
	public ResponseEntity<Object> editarCliente(Cliente cliente){
		Optional<Cliente> clienteEditar = clienteRepository.findById(cliente.getClienteId());
		Object clienteEditarObj = new Object();
		if(clienteEditar.isPresent()) {
			clienteEditarObj = clienteEditar.get();
			return ResponseEntity.ok().body(clienteEditarObj);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clienteEditarObj);
		}
	}
	
	public ResponseEntity<Object> eliminarCliente(Cliente idCliente){
		Optional<Cliente> clienteEliminar = clienteRepository.findById(idCliente.getClienteId());		
		if(clienteEliminar.isPresent()) {
			clienteRepository.delete(clienteEliminar.get());
			return ResponseEntity.ok().body(MENSAJE_ELIMINAR_OK);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clienteEliminar);
		}
	}

}
