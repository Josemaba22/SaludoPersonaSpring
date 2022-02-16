package com.neoris.saludo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.saludo.entity.Saludo;
import com.neoris.saludo.exception.TypeAlredyExistException;
import com.neoris.saludo.repository.SaludoRepository;
import com.neoris.saludo.request.CreateSaludoRequest;

@Service
public class SaludoService {

	@Autowired
	private SaludoRepository saludoRepository;
	
	public List<Saludo> getAllSaludo(){
		return saludoRepository.findAll();
	}
	
	public Saludo guardarSaludo(CreateSaludoRequest createSaludoRequest) {
		Saludo saludo = new Saludo(createSaludoRequest);
		
		if(saludoRepository.findByTipo(saludo.getTipo()) != null) {
			throw new TypeAlredyExistException();
		}
		saludo = saludoRepository.save(saludo);
		return saludo;			
		
	}

	
	/*
	public Saludo guardarSaludo(CreateSaludoRequest createSaludoRequest) {
		Saludo saludo = new Saludo(createSaludoRequest);
		return saludoRepository.save(saludo);
		
	}
	*/

	
	
	public Saludo getById(long id) {
		return saludoRepository.findById(id).get();
	}
	
	public Saludo getByTipo(String tipo) {
		
		return saludoRepository.findByTipo(tipo);
		
	}
	
	
	
	
	
	
	
	
}
