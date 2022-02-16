package com.neoris.persona.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.persona.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

	public Persona findByNombre(String nombre);

}
