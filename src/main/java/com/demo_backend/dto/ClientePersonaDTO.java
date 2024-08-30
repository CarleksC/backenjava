package com.demo_backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientePersonaDTO {
	
		
	private Integer personaid;
	private String direccion;
	private Integer edad;
	private String contrasenia;
	private String nombre;
	private String genero;	
	private String identificacion;	
	private String telefono;
	private Boolean estado;
	
	

}
