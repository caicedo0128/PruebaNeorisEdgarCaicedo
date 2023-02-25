package com.pruebaNeoris.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pruebaNeoris.Entity.Persona;
import com.pruebaNeoris.Repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	PersonaRepository personaRepository;
	
	private final static String MENSAJE_ELIMINAR_OK = "Persona Eliminada con Exito";
	
	public boolean findByIdentificacion(String identificacion) {
		try {
			Optional<Persona> nuevoPersona = personaRepository.findByIdentificacion(identificacion);	
			if(nuevoPersona.isPresent()) {
				return true;
			}else {
				return false;
			}			
		}catch (Exception e) {
			return false;
		}
		
	}
	
	public ResponseEntity<Object> crearPersona(Persona persona){
		Persona nuevoPersona = personaRepository.save(persona);	
		Optional<Persona> personaEncontrado = personaRepository.findById(nuevoPersona.getId());
		return ResponseEntity.ok().body(personaEncontrado);
	}
	
	public ResponseEntity<Object> editarCliente(Persona persona){
		Optional<Persona> personaEditar = personaRepository.findById(persona.getId());
		Object personaEditarObj = new Object();
		if(personaEditar.isPresent()) {
			personaEditarObj = personaEditar.get();
			return ResponseEntity.ok().body(personaEditarObj);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(personaEditarObj);
		}
	}
	
	public ResponseEntity<Object> eliminarCliente(Persona idCliente){
		Optional<Persona> personaEliminar = personaRepository.findById(idCliente.getId());		
		if(personaEliminar.isPresent()) {
			personaRepository.delete(personaEliminar.get());
			return ResponseEntity.ok().body(MENSAJE_ELIMINAR_OK);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(personaEliminar);
		}
	}

}
