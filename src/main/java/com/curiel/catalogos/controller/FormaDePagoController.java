package com.curiel.catalogos.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curiel.catalogos.service.FormaDePagoService;
import com.curiel.catalogos.model.dto.FormaDePagoDto;

@RestController
@RequestMapping("api/v1/formasdepago")
public class FormaDePagoController {
	
  @Autowired
  private FormaDePagoService formaDePagoService;
  
  @GetMapping
  public ResponseEntity<Set<FormaDePagoDto>> getAll(){
	  return new ResponseEntity<>(formaDePagoService.list(),HttpStatus.OK);
  }
  @PostMapping
  public ResponseEntity<FormaDePagoDto> saveFormadepago(@RequestBody FormaDePagoDto formaPago){
	  return new ResponseEntity<>(formaDePagoService.save(formaPago),HttpStatus.OK);
  }
}
