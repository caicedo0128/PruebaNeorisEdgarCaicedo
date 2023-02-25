package com.pruebaNeoris.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pruebaNeoris.Entity.Cliente;
import com.pruebaNeoris.Entity.Persona;
import com.pruebaNeoris.Repository.ClienteRepository;
import com.pruebaNeoris.Repository.PersonaRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	PersonaRepository personaRepository;
	
	private final static String MENSAJE_ELIMINAR_OK = "Cliente Eliminado con Exito";
	
	public ResponseEntity<Object> crearCliente(Cliente cliente){
		if(!personaService.findByIdentificacion(cliente.getPersona().getIdentificacion())) {
			Persona nuevaPersona = personaRepository.save(cliente.getPersona());
			cliente.setPersona(nuevaPersona);
			Cliente nuevoCliente = clienteRepository.save(cliente);	
			Optional<Cliente> clienteEncontrado = clienteRepository.findById(nuevoCliente.getClienteId());
			return ResponseEntity.ok().body(clienteEncontrado);
		}else {
			return ResponseEntity.ok().body("Cliente ya existe");
		}
		
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
