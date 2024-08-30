package com.demo_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo_backend.model.Persona;
import com.demo_backend.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/id")
	public ResponseEntity<Persona> listarPorId(
			@PathVariable("id") Long id){
		Persona obj= personaService.listarPorId(id);
		return new ResponseEntity<Persona>(obj,HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Validated @RequestBody Persona objO){
		Persona obj = personaService.registrar(objO);
		return new ResponseEntity<Object>(obj,HttpStatus.OK);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Object> modificar(@Validated @RequestBody Persona objO){
		Persona obj = personaService.modificar(objO);
		return new ResponseEntity<Object>(obj,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id ){
		Persona obj = personaService.listarPorId(Long.valueOf(id));
		if(obj == null) {
			return new ResponseEntity<Object>("ID no encontrado",HttpStatus.OK);
			
		}
		personaService.eliminar(Long.valueOf(id));
		return new ResponseEntity<Object>("Eliminado",HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> lista= personaService.listarTodo();
		return new ResponseEntity<List<Persona>>(lista,HttpStatus.OK);
	}
}
