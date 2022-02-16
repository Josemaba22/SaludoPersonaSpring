package com.neoris.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neoris.empresa.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
