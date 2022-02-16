package com.neoris.persona.response;

import com.neoris.persona.entity.Persona;
import com.neoris.saludo.response.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaSaludoResponse {
	
	private long id;
	private String nombrePersona;
	private int edad;
	private String direccionPersona;
	private String nombreEmpresa;
	private String direccionEmpresa;
	private SaludoResponse saludo;
	
	public PersonaSaludoResponse(Persona persona, SaludoResponse saludosPrro) {
		this.saludo = saludosPrro;
		this.id = persona.getId();
		this.nombrePersona = persona.getNombre();
		this.edad = persona.getEdad();
		this.direccionPersona = persona.getDireccionPersona();
		this.nombreEmpresa = persona.getEmpresa().getNombreEmpresa();
		this.direccionEmpresa = persona.getEmpresa().getDireccionEmpresa();
	}

}
