package com.curiel.catalogos.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curiel.catalogos.model.dto.ReferenciaPagoDto;
import com.curiel.catalogos.service.ReferenciaPagoService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1/referenciaspago")
public class ReferenciaPagoController implements GenericController<ReferenciaPagoDto, Long>{
	
	@Autowired
	private ReferenciaPagoService referenciaPagoService;
	
    
	@Override
	@GetMapping
	public ResponseEntity<Set<ReferenciaPagoDto>> list() {
		return new ResponseEntity<>(referenciaPagoService.list(),HttpStatus.OK);
	}
	@GetMapping("/{id}/formasdepago")
	public ResponseEntity<Set<ReferenciaPagoDto>> findByFormaDePagoId(@PathVariable Long id) {
		return new ResponseEntity<>(referenciaPagoService.findByFormaDePagoId(id),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ReferenciaPagoDto> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ReferenciaPagoDto> save(ReferenciaPagoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ReferenciaPagoDto> update(ReferenciaPagoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ReferenciaPagoDto> getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
