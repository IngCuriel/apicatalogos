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
import com.curiel.catalogos.model.dto.SucursalDto;
import com.curiel.catalogos.service.SucursalService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1/sucursales")
public class SucursalController implements GenericController<SucursalDto, Long> {

    @Autowired
    private SucursalService sucursalService;

    @Override
    @GetMapping
    public ResponseEntity<Set<SucursalDto>> list() {
         return new ResponseEntity<>(sucursalService.list(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<SucursalDto> delete(@PathVariable Long id) {
         sucursalService.delete(id);
         return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<SucursalDto> save(@RequestBody SucursalDto dto) {
         return new ResponseEntity<>(sucursalService.save(dto),HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<SucursalDto> update(@RequestBody SucursalDto dto) {
        return new ResponseEntity<>(sucursalService.save(dto),HttpStatus.OK);
     }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<SucursalDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(sucursalService.getById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Integer> updateStatus(@PathVariable Long id,@RequestParam int status) {
        return new ResponseEntity<>(sucursalService.updateByStatus(id, status),HttpStatus.OK);
    }
    
    @PutMapping("/{id}/megusta")
    public ResponseEntity<Integer> updateByIdAndMeGusta(@PathVariable Long id) {
        return new ResponseEntity<>(sucursalService.updateByIdAndMeGusta(id),HttpStatus.OK);
    }
    
    @GetMapping("/status")
    public ResponseEntity<Set<SucursalDto>> listByStatus(@RequestParam int status) {
        return new ResponseEntity<>(sucursalService.listByStatus(status),HttpStatus.OK);
 
    }
}
