package com.curiel.catalogos.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curiel.catalogos.model.dto.CategoriaDto;
import com.curiel.catalogos.service.CategoriaService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController implements GenericController<CategoriaDto, Long>{
	
	@Autowired
	private CategoriaService  categoriaService;

	@Override
	@GetMapping
	public ResponseEntity<Set<CategoriaDto>> list() {
 		return new ResponseEntity<>(categoriaService.list(),HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<CategoriaDto> delete(@PathVariable Long id) {
		categoriaService.delete(id);
 		return new ResponseEntity<>(null,HttpStatus.OK);
	}

	@Override
	@PostMapping
	public ResponseEntity<CategoriaDto> save(@RequestBody CategoriaDto dto) {
 		return new ResponseEntity<>(categoriaService.save(dto),HttpStatus.OK);
	}

	@Override
	@PutMapping
	public ResponseEntity<CategoriaDto> update(@RequestBody CategoriaDto dto) {
 		return new ResponseEntity<>(categoriaService.save(dto),HttpStatus.OK);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> getById(@PathVariable Long id) {
 		return new ResponseEntity<>(categoriaService.getById(id),HttpStatus.OK);
	}
	
	/*@GetMapping("/{id}/subcategoria")
	public ResponseEntity<Set<CategoriaDto>> listSubcategoria(@PathVariable Long id,@RequestParam int status) {
 		return new ResponseEntity<>(categoriaService.listSubCategoria(id, status),HttpStatus.OK);
	}
	*/
	@GetMapping("/padres")
	public ResponseEntity<Set<CategoriaDto>> listCategoria(@RequestParam int status) {
 		return new ResponseEntity<>(categoriaService.listCategoria(status),HttpStatus.OK);
	}
	
}
