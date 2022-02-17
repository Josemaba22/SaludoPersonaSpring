package com.neoris.saludo.response;


import com.neoris.saludo.entity.Saludo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaludoResponse {

	private long id;
	private String tipo;
	private String mensaje;

	public SaludoResponse(Saludo saludo) {
		this.id = saludo.getId();
		this.tipo = saludo.getTipo();
		this.mensaje = saludo.getMensaje();
	}
	
}
