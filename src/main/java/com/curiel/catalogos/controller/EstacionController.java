package com.curiel.catalogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curiel.catalogos.model.entity.Estacion;
import com.curiel.catalogos.repository.EstacionRepository;

@RestController
@RequestMapping(value="api/v1/estaciones")
public class EstacionController {
	
	@Autowired
	private EstacionRepository estacionRepository;
	
	@GetMapping
	public List<Estacion> getAll()
	{
		return estacionRepository.findAll();
	}
	
	@PostMapping
	public Estacion save(@RequestBody Estacion estacion) {
		
		return estacionRepository.save(estacion);
	}
}
