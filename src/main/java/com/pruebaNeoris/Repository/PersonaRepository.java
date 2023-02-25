package com.pruebaNeoris.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebaNeoris.Entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
	Optional<Persona> findByIdentificacion(String identificacion);

}
