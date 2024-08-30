package com.demo_backend.controller;

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

import com.demo_backend.dto.MovimientosDTO;
import com.demo_backend.model.Cuenta;
import com.demo_backend.model.Movimientos;
import com.demo_backend.service.ICuentaService;
import com.demo_backend.service.IMovimientosService;

@RestController
@RequestMapping("/movimientos")
public class MovimientosController {

	@Autowired
	private IMovimientosService MovimientosService;
	@Autowired
	private ICuentaService cuentaService;
	
	@GetMapping("/id")
	public ResponseEntity<Movimientos> listarPorId(
			@PathVariable("id") Long id){
		Movimientos obj= MovimientosService.listarPorId(id);
		return new ResponseEntity<Movimientos>(obj,HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Object> guardar(@Validated @RequestBody MovimientosDTO objO){
		//cuando se hace un moviento se debe actualizar el saldo
		//validar numero de cuenta
		Cuenta cuentaobj = cuentaService.listarPorNumCuenta(objO.getNumerocuenta());
		//System.out.println("numero cuenta "+ cuentaobj.getNumerocuenta());
		if(cuentaobj.getSaldoinicial()>0) {
			if(objO.getTipocuenta().equals("AHORROS")) {
				if(objO.getTipomovimiento().equals("Deposito")) {
					cuentaobj.setSaldoinicial(cuentaobj.getSaldoinicial()+objO.getValor()); 
					
				}
				else if(objO.getTipomovimiento().equals("Retiro")){
					cuentaobj.setSaldoinicial(cuentaobj.getSaldoinicial()-objO.getValor()); 
				}	
			}
			else if(objO.getTipocuenta().equals("CORRIENTE")) {
				if(objO.getTipomovimiento().equals("Deposito")) {
					cuentaobj.setSaldoinicial(cuentaobj.getSaldoinicial()+objO.getValor()); 
					
				}
				else if(objO.getTipomovimiento().equals("Retiro")){
					cuentaobj.setSaldoinicial(cuentaobj.getSaldoinicial()-objO.getValor()); 
				}
			}			
			//System.out.println("saldo inicial "+ cuentaobj.getTipocuenta());
			cuentaService.registrar(cuentaobj);			
			Movimientos obj1 = new Movimientos();
			obj1.setCuenta(cuentaobj);
			obj1.setFecha(objO.getFecha());
			obj1.setSaldo(cuentaobj.getSaldoinicial());
			obj1.setTipomovimiento(objO.getTipomovimiento());
			obj1.setValor(objO.getValor());			
			Movimientos obj = MovimientosService.registrar(obj1);
			return new ResponseEntity<Object>(obj,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Saldo no Disponible",HttpStatus.CONFLICT);
		}			
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Object> modificar(@Validated @RequestBody Movimientos objO){
		Movimientos obj = MovimientosService.modificar(objO);
		return new ResponseEntity<Object>(obj,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Movimientos>> listar(){
		List<Movimientos> lista= MovimientosService.listarTodo();
		return new ResponseEntity<List<Movimientos>>(lista,HttpStatus.OK);
	}
}
