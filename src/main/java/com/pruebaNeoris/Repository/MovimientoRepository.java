package com.pruebaNeoris.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebaNeoris.Entity.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{

}
