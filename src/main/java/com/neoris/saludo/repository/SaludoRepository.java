package com.neoris.saludo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.saludo.entity.Saludo;

@Repository
public interface SaludoRepository extends JpaRepository<Saludo, Long>{

	public Saludo findByTipo(String tipo);
	
}
