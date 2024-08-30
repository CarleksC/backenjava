package com.demo_backend.controller;

import java.util.ArrayList;
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

import com.demo_backend.dto.CuentaClientePersonaDTO;
import com.demo_backend.model.Cliente;
import com.demo_backend.model.Cuenta;
import com.demo_backend.service.ICuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

	@Autowired
	private ICuentaService CuentaService;
	
	@GetMapping("/id")
	public ResponseEntity<Cuenta> listarPorId(
			@PathVariable("id") Long id){
		Cuenta obj= CuentaService.listarPorId(id);
		return new ResponseEntity<Cuenta>(obj,HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Validated @RequestBody Cuenta objO){
		Cliente obj1 = new Cliente();
		obj1.setClienteid(objO.getCuentaid());
		Cuenta obj2 = new Cuenta();
		obj2.setCliente(obj1);
		obj2.setEstado(objO.getEstado());
		obj2.setNumerocuenta(objO.getNumerocuenta());
		obj2.setSaldoinicial(objO.getSaldoinicial());
		obj2.setTipocuenta(objO.getTipocuenta());
		Cuenta obj = CuentaService.registrar(obj2);
		return new ResponseEntity<Object>(obj,HttpStatus.OK);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Object> modificar(@Validated @RequestBody Cuenta objO){
		
		Cliente obj1 = new Cliente();
		obj1.setClienteid(objO.getCuentaid());
		Cuenta obj2 = new Cuenta();
		obj2.setCliente(obj1);
		obj2.setEstado(objO.getEstado());
		obj2.setNumerocuenta(objO.getNumerocuenta());
		obj2.setSaldoinicial(objO.getSaldoinicial());
		obj2.setTipocuenta(objO.getTipocuenta());		
		Cuenta obj = CuentaService.modificar(obj2);
		return new ResponseEntity<Object>(obj,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Cuenta>> listar(){
		List<Cuenta> lista= CuentaService.listarTodo();
		return new ResponseEntity<List<Cuenta>>(lista,HttpStatus.OK);
	}
	@GetMapping("/usuario")
	public ResponseEntity<List<CuentaClientePersonaDTO>> listarCuentaUsuario(){
		
		List<CuentaClientePersonaDTO> lista=new ArrayList<>(); 
		CuentaService.listarTodo().forEach(x->{
			CuentaClientePersonaDTO con = new CuentaClientePersonaDTO();
			con.setCliente(x.getCliente().getPersona().getNombre());
			con.setEstado(x.getEstado());
			con.setNumerocuenta(x.getNumerocuenta());
			con.setSaldoinicial(x.getSaldoinicial());
			con.setTipocuenta(x.getTipocuenta());
			lista.add(con);
		});		
		return new ResponseEntity<List<CuentaClientePersonaDTO>>(lista,HttpStatus.OK);					
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id ){
		Cuenta obj = CuentaService.listarPorId(Long.valueOf(id));
		if(obj == null) {
			return new ResponseEntity<Object>("ID no encontrado",HttpStatus.OK);
			
		}
		CuentaService.eliminar(Long.valueOf(id));
		return new ResponseEntity<Object>("Eliminado",HttpStatus.NO_CONTENT);
	}
}
