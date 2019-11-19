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
import com.curiel.catalogos.model.dto.ProductoDto;
import com.curiel.catalogos.service.ProductoService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1")
public class ProductoController implements GenericController<ProductoDto, Long>{
    
    @Autowired
    private ProductoService productoService;

    @Override
    @GetMapping("/productos")
    public ResponseEntity<Set<ProductoDto>> list() {
         return new ResponseEntity<>(productoService.list(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<ProductoDto> delete(@PathVariable Long id) {
         productoService.delete(id);
         return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @Override
    @PostMapping("/productos")
    public ResponseEntity<ProductoDto> save(@RequestBody ProductoDto dto) {
         return new ResponseEntity<>(productoService.save(dto),HttpStatus.OK);
    }

    @Override
    @PutMapping("/productos")
    public ResponseEntity<ProductoDto> update(@RequestBody ProductoDto dto) {
        return new ResponseEntity<>(productoService.save(dto),HttpStatus.OK);
    }

    @Override
    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoDto> getById(@PathVariable Long id) {
         return new ResponseEntity<>(productoService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/sucursales/{id}/productos")
    public ResponseEntity<Set<ProductoDto>> getProductosBySucursalId(@PathVariable long id,@RequestParam int status){
    	return new ResponseEntity<>(productoService.listProductosBySucursalIdAndStatus(id,status),HttpStatus.OK);
    }
    
    @GetMapping("/categorias/{id}/productos")
    public ResponseEntity<Set<ProductoDto>> getProductosByCategorialId(@PathVariable long id,@RequestParam int status){
    	return new ResponseEntity<>(productoService.listProductosByCategorialIdAndStatus(id,status),HttpStatus.OK);
    }
    
    @GetMapping("/productos/like")
    public ResponseEntity<Set<ProductoDto>> getProductosByNombreLike(@RequestParam String nombre,@RequestParam int status){
    	return new ResponseEntity<>(productoService.listProductosByNombreLikeAndStatus(nombre,status),HttpStatus.OK);
    }
      
      
    
    

}
