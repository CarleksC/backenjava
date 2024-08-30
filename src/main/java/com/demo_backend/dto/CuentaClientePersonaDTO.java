package com.demo_backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CuentaClientePersonaDTO {
	
	private String numerocuenta;
	private String tipocuenta;
	private Float saldoinicial;
	private Boolean estado;
	private String cliente;
		

}
