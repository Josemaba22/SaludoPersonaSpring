package com.neoris.saludo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.neoris.saludo.request.CreateSaludoRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "saludo")
public class Saludo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tipo",unique=true)
	private String tipo;
	
	@Column(name = "mensaje")
	private String mensaje;
	
	
	public Saludo(CreateSaludoRequest createSaludoRequest) {
		
		this.tipo = createSaludoRequest.getTipo();
		this.mensaje = createSaludoRequest.getMensaje();
		
	}

}
