package com.neoris.persona.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePersonaRequest {

	private String nombrePersona;
	private int edad;
	private String direccionPersona;
	private String nombreEmpresa;
	private String direccionEmpresa;
	
}
