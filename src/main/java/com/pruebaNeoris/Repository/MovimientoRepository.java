package com.pruebaNeoris.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebaNeoris.Entity.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{
	
	@Query(value = "select mv.* from db_pruebaneoris.movimientos mv, db_pruebaneoris.cuenta ct, db_pruebaneoris.cliente cl, db_pruebaneoris.persona per "
			+ "where mv.cuenta = ct.id and ct.cliente = cl.cliente_id and cl.persona = per.id "
			+ "and mv.fecha > :fechaInicial and mv.fecha < :fechaFinal and cl.cliente_id = :clienteId", nativeQuery = true)
	List<Movimiento> listadoMovimientos(@Param("fechaInicial") Date fechaInicial, @Param("fechaFinal") Date fechaFinal, @Param("clienteId") Long clienteId);

}
