package com.demo_backend.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@ToString(of="clienteid")
@EqualsAndHashCode(of="clienteid")

@Data
@Entity
@Table(name="cliente", schema="datos")
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long clienteid;
	
	@JsonIgnore	
	@ManyToOne
	@JoinColumn(name = "personaid", nullable = false, foreignKey = @ForeignKey(name = "FK_idpersona"))
	private Persona persona;
	private String contrasenia;
	private Boolean estado;

}
