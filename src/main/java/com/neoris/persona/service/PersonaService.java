package com.neoris.persona.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.neoris.empresa.entity.Empresa;
import com.neoris.empresa.repository.EmpresaRepository;
import com.neoris.persona.entity.Persona;
import com.neoris.persona.repository.PersonaRepository;
import com.neoris.persona.request.CreatePersonaRequest;
import com.neoris.persona.response.PersonaResponse;
import com.neoris.persona.response.PersonaSaludoResponse;
import com.neoris.saludo.exception.NameAlredyExistException;
import com.neoris.saludo.exception.NoHayPersonasException;
import com.neoris.saludo.exception.PersonaNoExisteException;
import com.neoris.saludo.response.SaludoResponse;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<Persona> getAll(){
		if(personaRepository.findAll().isEmpty()) {
			throw new NoHayPersonasException();
		}
		return personaRepository.findAll();
	}
	
	public SaludoResponse getSaludo() {
		RestTemplate rt = new RestTemplate();
		LocalDateTime hora = LocalDateTime.now();
		int horaActual = hora.getHour();
		if(horaActual >= 5 && horaActual < 12) {
			return rt.getForObject("http://localhost:8080/api/saludo/get/Mañana",SaludoResponse.class);
		}
		if(horaActual >= 12 && horaActual <= 18) {
			return rt.getForObject("http://localhost:8080/api/saludo/get/Tarde",SaludoResponse.class);
		}
		//if(horaActual >= 19 && horaActual <= 4) {
		//}
		return rt.getForObject("http://localhost:8080/api/saludo/get/Noche",SaludoResponse.class);
		
	}
	
	public Persona getByNombre(String nombre) {
		if(personaRepository.findByNombre(nombre) == null) {
			throw new PersonaNoExisteException();
		}
		return personaRepository.findByNombre(nombre);
	}
	
	public PersonaSaludoResponse guardar(CreatePersonaRequest request) {
		Persona persona = new Persona(request);
		Empresa empresa = new Empresa();
		empresa.setNombreEmpresa(request.getNombreEmpresa());
		empresa.setDireccionEmpresa(request.getDireccionEmpresa());
		
		if(personaRepository.findByNombre(persona.getNombre()) != null) {
			throw new NameAlredyExistException();
		}
		
		if(empresaRepository.findByNombreEmpresa(empresa.getDireccionEmpresa()) == null) {
			empresaRepository.save(empresa);
		} else {
			empresa = empresaRepository.findByNombreEmpresa(empresa.getNombreEmpresa());
		}
		persona.setEmpresa(empresa);
		
		return new PersonaSaludoResponse(personaRepository.save(persona), getSaludo()) ;
		
	}
	
}
