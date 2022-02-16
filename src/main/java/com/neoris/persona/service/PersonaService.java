package com.neoris.persona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.persona.entity.Persona;
import com.neoris.persona.repository.PersonaRepository;
import com.neoris.persona.request.CreatePersonaRequest;
import com.neoris.saludo.exception.NameAlredyExistException;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	public List<Persona> getAll(){
		return personaRepository.findAll();
	}
	
	public Persona guardar(CreatePersonaRequest request) {
		Persona persona = new Persona(request);
		
		if(personaRepository.findByNombre(persona.getNombre()) != null) {
			throw new NameAlredyExistException();
		}
		return personaRepository.save(persona);
	}
	
}
