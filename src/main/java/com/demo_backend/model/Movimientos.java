package com.demo_backend.model;

import java.io.Serializable;
import java.util.Date;

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
@ToString(of="movimientoid")
@EqualsAndHashCode(of="movimientoid")

@Data
@Entity
@Table(name="movimientos", schema="datos")
public class Movimientos implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long movimientoid;	
	private Date fecha;
	private String tipomovimiento;
	private Float valor;
	private Float saldo;
	@JsonIgnore	
	@ManyToOne
	@JoinColumn(name = "idcuenta", nullable = false, foreignKey = @ForeignKey(name = "FK_idcuenta"))
	private Cuenta cuenta; 

}
