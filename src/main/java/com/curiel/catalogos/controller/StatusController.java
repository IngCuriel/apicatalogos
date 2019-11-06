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
import org.springframework.web.bind.annotation.RestController;
import com.curiel.catalogos.model.dto.StatusDto;
import com.curiel.catalogos.service.StatusService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1/status")
public class StatusController implements GenericController<StatusDto, Long> {
    
    @Autowired
    private StatusService statusService;

    @Override
    @GetMapping
    public ResponseEntity<Set<StatusDto>> list() {
         return new ResponseEntity<>(statusService.list(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<StatusDto> delete(@PathVariable Long id) {
         statusService.delete(id);
         return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<StatusDto> save(@RequestBody StatusDto dto) {
         return new ResponseEntity<>(statusService.save(dto),HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<StatusDto> update(@RequestBody StatusDto dto) {
        return new ResponseEntity<>(statusService.save(dto),HttpStatus.OK);
     }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StatusDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(statusService.getById(id),HttpStatus.OK);
    }
    
}
