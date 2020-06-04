package com.curiel.catalogos.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curiel.catalogos.model.dto.MovimientoFormaPagoDto;
import com.curiel.catalogos.service.MovimientoFormaPagoService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1/pagos/movimientos")
public class MovimientoFormaPagoController implements GenericController<MovimientoFormaPagoDto, Long> {
	
	@Autowired
    private MovimientoFormaPagoService movimientoFormaPagoService;

	@Override
	@GetMapping
	public ResponseEntity<Set<MovimientoFormaPagoDto>> list() {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(movimientoFormaPagoService.list(),HttpStatus.OK);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Set<MovimientoFormaPagoDto>> findByMovimientoId(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(movimientoFormaPagoService.findByMovimientoId(id),HttpStatus.OK);
	}
	


	@Override
	public ResponseEntity<MovimientoFormaPagoDto> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<MovimientoFormaPagoDto> save(MovimientoFormaPagoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping
	public ResponseEntity<MovimientoFormaPagoDto> update(@RequestBody MovimientoFormaPagoDto dto) {
		System.out.print(dto);
 		return new ResponseEntity<MovimientoFormaPagoDto>(movimientoFormaPagoService.update(dto),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<MovimientoFormaPagoDto> getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
  
}
