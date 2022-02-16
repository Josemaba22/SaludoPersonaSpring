package com.neoris.empresa.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.neoris.persona.entity.Persona;
import com.neoris.persona.request.CreatePersonaRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa")
	private Long idEmpresa;
	
	@Column(name = "nombre")
	private String nombreEmpresa;
	
	@Column(name = "direccion")
	private String direccionEmpresa;
	
	@OneToMany(mappedBy = "empresa")
	private List<Persona> personal;
	
	public Empresa(CreatePersonaRequest request) {
		this.nombreEmpresa = request.getNombreEmpresa();
		this.direccionEmpresa = request.getDireccionEmpresa();
		
	}
	
}
