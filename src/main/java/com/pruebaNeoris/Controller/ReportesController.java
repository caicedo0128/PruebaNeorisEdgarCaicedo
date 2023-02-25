package com.pruebaNeoris.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaNeoris.Dto.MovimientosDto;
import com.pruebaNeoris.Service.ReportesService;

@RestController
@RequestMapping("/reportes")
public class ReportesController {
	
	@Autowired
	ReportesService reporteService;
	
	@GetMapping()
	public ResponseEntity<List<MovimientosDto>> buscarByFechaCliente(@RequestParam("fechaInicial") 
	  @DateTimeFormat(pattern = "dd.MM.yyyy") Date fechaInicial, @RequestParam("fechaFinal") 
	  @DateTimeFormat(pattern = "dd.MM.yyyy") Date fechaFinal, @RequestParam("clienteId") Long clienteId){
		return reporteService.listarMovimientosByFechaNumeroCuenta(fechaInicial,fechaFinal, clienteId);
	}

}
