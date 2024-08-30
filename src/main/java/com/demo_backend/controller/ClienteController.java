package com.demo_backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo_backend.dto.ClientePersonaDTO;
import com.demo_backend.model.Cliente;
import com.demo_backend.model.Persona;
import com.demo_backend.service.IClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/id")
	public ResponseEntity<Cliente> listarPorId(
			@PathVariable("id") Long id){
		Cliente obj= clienteService.listarPorId(id);
		return new ResponseEntity<Cliente>(obj,HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Validated @RequestBody Cliente objO){
		Persona obj1 = new Persona();
		obj1.setPersonaid(objO.getClienteid());
		Cliente obj2= new Cliente();		
		obj2.setContrasenia(objO.getContrasenia());
		obj2.setEstado(objO.getEstado());
		obj2.setPersona(obj1);
		Cliente obj = clienteService.registrar(obj2);
		return new ResponseEntity<Object>(obj,HttpStatus.OK);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Object> modificar(@Validated @RequestBody Cliente objO){
		Cliente obj1 = clienteService.listarPorId(objO.getClienteid());
		Persona obj2 = new Persona();
		obj2.setPersonaid(obj1.getClienteid());
		
		obj1.setContrasenia(objO.getContrasenia());
		obj1.setEstado(objO.getEstado());
		obj1.setEstado(objO.getEstado());		
		Cliente obj = clienteService.modificar(obj1);
		return new ResponseEntity<Object>(obj,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> lista=clienteService.listarTodo();
		return new ResponseEntity<List<Cliente>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/persona")
	public ResponseEntity<List<ClientePersonaDTO>> listarClientePersona(){
		List<ClientePersonaDTO> lista = new ArrayList<>();
		clienteService.listarTodo().forEach(x->{
			ClientePersonaDTO con = new ClientePersonaDTO();
			con.setPersonaid(Integer.valueOf(x.getPersona().getPersonaid().toString()));
			con.setDireccion(x.getPersona().getDireccion());
			con.setEdad(x.getPersona().getEdad());
			con.setContrasenia(x.getContrasenia());
			con.setNombre(x.getPersona().getNombre());
			con.setGenero(x.getPersona().getGenero());
			con.setIdentificacion(x.getPersona().getIdentificacion());
			con.setTelefono(x.getPersona().getTelefono());
			con.setEstado(x.getEstado());					
			lista.add(con);
		});;
		return new ResponseEntity<List<ClientePersonaDTO>>(lista,HttpStatus.OK);
	}
}
