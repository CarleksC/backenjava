package com.demo_backend.dto;

import java.util.Date;

import com.demo_backend.model.Cuenta;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovimientosDTO {
	
	private Date fecha;
	private String tipomovimiento;	
	private String numerocuenta;
	private String tipocuenta;
	private Float valor;
	private Float saldo;
	
	
		

}
