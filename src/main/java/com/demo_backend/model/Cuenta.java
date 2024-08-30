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
@ToString(of="cuentaid")
@EqualsAndHashCode(of="cuentaid")

@Data
@Entity
@Table(name="cuenta", schema="datos")
public class Cuenta implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long cuentaid;	
	private String numerocuenta;
	private String tipocuenta;
	private Float saldoinicial;
	private Boolean estado;
	
	@JsonIgnore	
	@ManyToOne
	@JoinColumn(name = "idcliente", nullable = false, foreignKey = @ForeignKey(name = "FK_idcliente"))
	private Cliente cliente;

}
