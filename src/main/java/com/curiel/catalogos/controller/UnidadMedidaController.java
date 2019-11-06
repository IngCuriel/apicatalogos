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
import com.curiel.catalogos.model.dto.UnidadMedidaDto;
import com.curiel.catalogos.service.UnidadMedidaService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1")
public class UnidadMedidaController implements GenericController<UnidadMedidaDto, Long>{
    
    @Autowired
    private UnidadMedidaService unidadMedidaService;
    
    @Override
    @GetMapping("/unidades")
    public ResponseEntity<Set<UnidadMedidaDto>> list() {
         return new ResponseEntity<>(unidadMedidaService.list(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/unidades/{id}")
    public ResponseEntity<UnidadMedidaDto> delete(@PathVariable Long id) {
        unidadMedidaService.delete(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @Override
    @PostMapping("/unidades")
    public ResponseEntity<UnidadMedidaDto> save(@RequestBody UnidadMedidaDto dto) {
        return new ResponseEntity<>(unidadMedidaService.save(dto),HttpStatus.OK);
    }

    @Override
    @PutMapping("/unidades")
    public ResponseEntity<UnidadMedidaDto> update(@RequestBody UnidadMedidaDto dto) {
        return new ResponseEntity<>(unidadMedidaService.save(dto),HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UnidadMedidaDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(unidadMedidaService.getById(id),HttpStatus.OK);
    }
    
    @GetMapping("/sucursales/{id}/unidades")
    public ResponseEntity<Set<UnidadMedidaDto>> getBySucursalId(@PathVariable Long id) {
        return new ResponseEntity<>(unidadMedidaService.getBySucursalId(id),HttpStatus.OK);
    }

    @PutMapping("/unidades/{id}/")
    public ResponseEntity<UnidadMedidaDto> updateStatus(@PathVariable Long id, @RequestParam Long  statusId) {
         unidadMedidaService.updateStatus(id, statusId);
         return new  ResponseEntity<>(null,HttpStatus.OK);
    }

}
