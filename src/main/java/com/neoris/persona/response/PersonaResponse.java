package com.neoris.persona.response;

import com.neoris.persona.entity.Persona;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaResponse {

	private long id;
	private String nombrePersona;
	private int edad;
	private String direccionPersona;
	private String nombreEmpresa;
	private String direccionEmpresa;
	
	public PersonaResponse(Persona persona) {
		this.id = persona.getId();
		this.nombrePersona = persona.getNombre();
		this.edad = persona.getEdad();
		this.direccionPersona = persona.getDireccionPersona();
		this.nombreEmpresa = persona.getEmpresa().getNombreEmpresa();
		this.direccionEmpresa = persona.getEmpresa().getDireccionEmpresa();
	}
	
}
