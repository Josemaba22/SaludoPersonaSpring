package com.neoris.persona.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.persona.entity.Persona;
import com.neoris.persona.request.CreatePersonaRequest;
import com.neoris.persona.response.PersonaResponse;
import com.neoris.persona.response.PersonaSaludoResponse;
import com.neoris.persona.service.PersonaService;

@RestController
@RequestMapping("/api/persona/")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("sas")
	public String sas() {
		return "sas";
	}
	
	@GetMapping("getAll")
	public List<PersonaResponse> getAll(){
		List<Persona> personaList = personaService.getAll();
		
		List<PersonaResponse> personaResponseList = new ArrayList<PersonaResponse>();
		
		personaList.stream().forEach(persona -> {
			personaResponseList.add(new PersonaResponse(persona));
		});
		
		return personaResponseList;
	}
	
	@PostMapping("create")
	public PersonaSaludoResponse createPersona(@Valid @RequestBody CreatePersonaRequest request) {
		PersonaSaludoResponse persona = personaService.guardar(request);
		return persona;
	}
	
	@GetMapping("getByNombre/{nombre}")
	public PersonaResponse getByNombre(@PathVariable String nombre) {
		return new PersonaResponse(personaService.getByNombre(nombre));
	}
}
