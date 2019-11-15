package com.curiel.catalogos.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curiel.catalogos.model.dto.UsuarioDto;
import com.curiel.catalogos.service.UsuarioService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController implements GenericController<UsuarioDto, Long> {
    
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public ResponseEntity<Set<UsuarioDto>> list() {
 		return null;
	}

	@Override
	public ResponseEntity<UsuarioDto> delete(Long id) {
 		return null;
	}

	@Override
	@PostMapping
	public ResponseEntity<UsuarioDto> save(@RequestBody UsuarioDto dto) {
		return new ResponseEntity<>(usuarioService.save(dto),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UsuarioDto> update(UsuarioDto dto) {
 		return null;
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> getById(@PathVariable Long id) {
 		return new ResponseEntity<>(usuarioService.getById(id),HttpStatus.OK);
	}
	
	@GetMapping("/email")
	public ResponseEntity<UsuarioDto> getByEmail(@RequestParam String email) {
 		return new ResponseEntity<>(usuarioService.getByEmail(email),HttpStatus.OK);
	}
	

}
