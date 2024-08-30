package com.demo_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo_backend.model.Persona;
import com.demo_backend.service.IPersonaService;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

	@Autowired
	private IPersonaService personaService;
	//TERMINAR EL REPORTE
	@GetMapping("/fechai/{fi}/fechaf/{ff}")
	public ResponseEntity<Object> reporte(@RequestParam("fi") String fi,@RequestParam("ff") String ff){
		//Persona obj= personaService.listarPorId(id);
		//CUENTAS ASOCIADAS
		//DETALLE DE MOVIMIENTO DE CUENTAS
		return new ResponseEntity<Object>("Reporte",HttpStatus.OK);
	}
	
	
}
