package com.neoris.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.empresa.entity.Empresa;
import com.neoris.empresa.repository.EmpresaRepository;
import com.neoris.empresa.request.EmpresaRequest;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;
	
	public Empresa getByNombreEmpresa(String nombre) {
		return empresaRepository.findByNombreEmpresa(nombre);
	}
	
	public Empresa guardarEmpresa(EmpresaRequest request) {
		Empresa empresa = new Empresa();
		empresa.setNombreEmpresa(request.getNombre());
		empresa.setDireccionEmpresa(request.getDireccion());
		return empresaRepository.save(empresa);
	}
	
}
