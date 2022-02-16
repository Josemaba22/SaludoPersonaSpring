package com.neoris.persona.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.neoris.empresa.entity.Empresa;
import com.neoris.persona.request.CreatePersonaRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "direccion")
	private String direccionPersona;
	
	@ManyToOne 
	@JoinColumn(name = "idEmpresa")
	private Empresa empresa;
	
	public Persona(CreatePersonaRequest request) {
		this.nombre = request.getNombrePersona();
		this.edad = request.getEdad();
		this.direccionPersona = request.getDireccionPersona();
	}
	
}
