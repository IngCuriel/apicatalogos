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
import com.curiel.catalogos.model.dto.ProductoDto;
import com.curiel.catalogos.service.ProductoService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1/productos")
public class ProductoController implements GenericController<ProductoDto, Long>{
    
    @Autowired
    private ProductoService productoService;

    @Override
    @GetMapping
    public ResponseEntity<Set<ProductoDto>> list() {
         return new ResponseEntity<>(productoService.list(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<ProductoDto> delete(@PathVariable Long id) {
         productoService.delete(id);
         return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto dto) {
         return new ResponseEntity<>(productoService.save(dto),HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<ProductoDto> update(@RequestBody ProductoDto dto) {
        return new ResponseEntity<>(productoService.save(dto),HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getById(@PathVariable Long id) {
         return new ResponseEntity<>(productoService.getById(id),HttpStatus.OK);
    }
    
    

}
