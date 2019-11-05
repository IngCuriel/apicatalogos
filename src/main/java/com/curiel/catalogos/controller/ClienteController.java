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
import com.curiel.catalogos.model.dto.ClienteDto;
import com.curiel.catalogos.service.ClienteService;
import com.curiel.catalogos.util.GenericController;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController implements GenericController<ClienteDto, Long> {
  
    @Autowired
    private ClienteService clienteService;

    @Override
    @GetMapping
    public ResponseEntity<Set<ClienteDto>> list() {
         return new ResponseEntity<>(clienteService.list(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteDto> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @Override
    @PostMapping
    public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto dto) {
        return new ResponseEntity<>(clienteService.save(dto),HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getById(@PathVariable Long id) {
         return new ResponseEntity<>(clienteService.getById(id),HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<ClienteDto> update(ClienteDto dto) {
         return new ResponseEntity<>(clienteService.save(dto),HttpStatus.OK);
    }    
}
