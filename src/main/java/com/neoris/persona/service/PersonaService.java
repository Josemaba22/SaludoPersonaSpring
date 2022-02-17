package com.neoris.persona.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.neoris.empresa.entity.Empresa;
import com.neoris.empresa.repository.EmpresaRepository;
import com.neoris.empresa.request.EmpresaRequest;
import com.neoris.empresa.service.EmpresaService;
import com.neoris.persona.entity.Persona;
import com.neoris.persona.repository.PersonaRepository;
import com.neoris.persona.request.CreatePersonaRequest;
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
	
	@Autowired
	private EmpresaService empresaService;
	
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
		Persona persona = new Persona();
		persona.setNombre(request.getNombrePersona());
		persona.setDireccionPersona(request.getDireccionPersona());
		persona.setEdad(request.getEdad());
		EmpresaRequest empresaRequest = new EmpresaRequest();
		empresaRequest.setDireccion(request.getDireccionEmpresa());
		empresaRequest.setNombre(request.getNombreEmpresa());
		
		if(personaRepository.findByNombre(persona.getNombre()) != null) {
			throw new NameAlredyExistException();
		}
		
		Empresa empresa = empresaRepository.findByNombreEmpresa(empresaRequest.getNombre());
		
		if(empresa == null) {
			empresa = empresaService.guardarEmpresa(empresaRequest);
		}
		
		persona.setEmpresa(empresa);
		personaRepository.save(persona);
		
		return new PersonaSaludoResponse(personaRepository.save(persona), getSaludo()) ;
		
	}
	
}
