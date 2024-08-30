package com.demo_backend.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovimientosFechaUsuarioDTO {
	
	private Date fecha;
	private String cliente;
	private String numerocuenta;
	private String tipocuenta;
	private Integer saldoinicial;
	private Boolean estado;
	private Float movimiento;//saldoinicial-valor
	//private String tipomovimiento;
	//private Float valor;
	private Float saldo;
		

}
