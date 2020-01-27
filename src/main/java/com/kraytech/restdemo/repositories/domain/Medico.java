package com.kraytech.restdemo.repositories.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombres;
	
	private String apellidos;
	
	private String telefono;
	
	public Medico() {
		
	}
	
	public Medico(String nombres, String apellidos, String telefono) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	
}
