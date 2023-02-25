package com.pruebaNeoris.pruebaNeoris;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebaNeoris.Entity.Cliente;
import com.pruebaNeoris.Entity.Cuenta;
import com.pruebaNeoris.Entity.Movimiento;
import com.pruebaNeoris.Repository.ClienteRepository;
import com.pruebaNeoris.Repository.CuentaRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class PruebaNeorisApplicationTests {
	
	public static final Long PRIMER_CLIENTE = 1l;

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CuentaRepository cuentaRepository;

	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
    @Test
    public void crearCuenta() throws Exception {
    	
    	Optional<Cliente> cli = clienteRepository.findById(1L);
    	
    	mvc.perform(MockMvcRequestBuilders
                .post("/cuentas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new CuentaTest(478759, "Ahorro", 2000L,true,cli.get()))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.cliente").exists());
    }
    
    @Test
    public void crearMovimiento() throws Exception {
    	
    	DateFormat formateador= new SimpleDateFormat("dd/MM/yyyy");
    	
    	Date fecha= formateador.parse("10/01/2023");
    	
    	Optional<Cuenta> cue = cuentaRepository.findById(1L);
    	
    	mvc.perform(MockMvcRequestBuilders
                .post("/movimientos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new MovimientoTest(fecha, "Deposito", 2000L,cue.get()))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.cuenta").exists());

    }

}
