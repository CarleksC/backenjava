package com.demo_backend.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(of="personaid")
@EqualsAndHashCode(of="personaid")

@Data
@Entity
@Table(name="persona", schema="datos")
public class Persona implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long personaid;	
	private String nombre;
	private String genero;
	private Integer edad;
	private String identificacion;
	private String direccion;
	private String telefono;

}
