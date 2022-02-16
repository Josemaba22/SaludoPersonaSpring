package com.neoris.saludo.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.saludo.entity.Saludo;
import com.neoris.saludo.request.CreateSaludoRequest;
import com.neoris.saludo.response.SaludoResponse;
import com.neoris.saludo.service.SaludoService;

@RestController
@RequestMapping("/api/saludo/")
public class SaludoController {

	@Autowired
	private SaludoService saludoService;
	
	@GetMapping("/sas")
	public String sas() {
		return "sas";
	}
	
	@GetMapping("/getAll")
	public List<SaludoResponse> getAll(){
		List<Saludo> saludoList = saludoService.getAllSaludo();
		List<SaludoResponse> saludoResponseList = new ArrayList<SaludoResponse>();
		
		saludoList.stream().forEach(saludo -> {
			saludoResponseList.add(new SaludoResponse(saludo));
		});
		
		return saludoResponseList;
	}
	
	/*
	@PostMapping("create")
	public ResponseEntity<Object> createSaludo(@Validated  @RequestBody CreateSaludoRequest createSaludoRequest) {
		
		ErrorDetails errorDetails = new ErrorDetails("900", "Tipo de saludo existente");
		try {
			Saludo saludo = saludoService.guardarSaludo(createSaludoRequest);
			SaludoResponse sr = new SaludoResponse(saludo);
			return new ResponseEntity<Object>(sr,HttpStatus.OK);
		} catch (TypeAlredyExistException e) {
			return new ResponseEntity<Object>(errorDetails,HttpStatus.CONFLICT);
		}
		
	}*/

	
	
	@PostMapping("create")
	public SaludoResponse createSaludo(@Validated  @RequestBody CreateSaludoRequest createSaludoRequest) {
		Saludo saludo = saludoService.guardarSaludo(createSaludoRequest);
		return new SaludoResponse(saludo);
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
