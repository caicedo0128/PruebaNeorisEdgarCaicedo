package com.pruebaNeoris.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebaNeoris.Entity.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
	
	Optional<Cuenta> findByNumeroCuenta (Integer numeroCuenta);

}
