package com.curiel.catalogos.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curiel.catalogos.model.dto.MovimientoDto;
import com.curiel.catalogos.service.MovimientoService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1/movimientos")
public class MovimientoController implements GenericController<MovimientoDto, Long> {
    
    @Autowired
    private MovimientoService movimientoService;

    @Override
    @GetMapping
    public ResponseEntity<Set<MovimientoDto>> list() {
         return new ResponseEntity<>(movimientoService.list(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<MovimientoDto> delete(@PathVariable Long id) {
        movimientoService.delete(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<MovimientoDto> save(@RequestBody MovimientoDto dto) {
        return new ResponseEntity<>(movimientoService.save(dto),HttpStatus.OK);
    }

    @Override
    @PutMapping()
    public ResponseEntity<MovimientoDto> update(@RequestBody MovimientoDto dto) {
        return new ResponseEntity<>(movimientoService.save(dto),HttpStatus.OK);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<String > updateMovimiento(@RequestBody  Map<String, Object> updates, Long id){
    	movimientoService.updateMovimiento(updates,id);
        return new ResponseEntity<>("Actualizado correctamente",HttpStatus.OK);
   }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(movimientoService.getById(id),HttpStatus.OK);
    }
    
    @GetMapping("/clientes")
    public ResponseEntity<List<MovimientoDto>> getByClienteProveedor(@RequestParam String  clienteProveedor) {
        return new ResponseEntity<List<MovimientoDto>>(movimientoService.getByClienteProveedor(clienteProveedor),HttpStatus.OK);
    }
 
    @GetMapping("/download.xlsx")
    public ResponseEntity<InputStreamResource>  generateExcelMovimiento() throws IOException {
 	   ByteArrayInputStream stream = movimientoService.generateExcelMovimientos();
 	   HttpHeaders headers=new HttpHeaders();
 	   headers.add("Content-Disposition", "attachment; filename=Movimientos.xlsx"); 	   
        return  ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
    }
 	
     
     

}
