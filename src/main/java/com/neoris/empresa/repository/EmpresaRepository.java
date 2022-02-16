package com.neoris.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.empresa.entity.Empresa;
import com.neoris.persona.entity.Persona;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	public Persona findById(long id);
	
	public Empresa findByNombreEmpresa(String nombre);

}
