package com.curiel.catalogos.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
import com.curiel.catalogos.model.entity.Producto;
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
    
    @GetMapping("/productos/page")
    public ResponseEntity<Page<ProductoDto>> getPageOfProductosByStatus(
				    		@RequestParam int status,
				    		@RequestParam Boolean visiblePage,
				    		@RequestParam(defaultValue = "0") int page,
				    		@RequestParam(defaultValue = "10") int size,
				    		@RequestParam(defaultValue = "nombre") String order,
				    		@RequestParam(defaultValue = "true") boolean asc
				    		){
    	Page<ProductoDto> productos= productoService.listProductosByStatus(status, visiblePage,PageRequest.of(page, size, Sort.by(order)));
    	if(!asc)
    		productos= productoService.listProductosByStatus(status, visiblePage,PageRequest.of(page, size, Sort.by(order).descending()));
    	return new ResponseEntity<>(productos,HttpStatus.OK);
    	
    }

    @GetMapping("/sucursales/{sucursalId}/productos")
    public ResponseEntity<Page<ProductoDto>> getPageOfProductosBySucursalIdAndStatus(
    		              @PathVariable("sucursalId") long sucursalId,
    		              @RequestParam int status,
     		              @RequestParam Boolean visiblePage,
     		              @RequestParam(defaultValue = "0") int page,
     		     		  @RequestParam(defaultValue = "10") int size,
     		     		  @RequestParam(defaultValue = "nombre") String order,
     		     		  @RequestParam(defaultValue = "true") boolean asc){
    	return new ResponseEntity<>(productoService.listProductosBySucursalIdAndStatus(sucursalId,status,visiblePage,PageRequest.of(page, size,Sort.by(order))),HttpStatus.OK);
    }
    
    @GetMapping("/categorias/{categoriaId}/productos")
    public ResponseEntity<Page<ProductoDto>> getPageOfProductosByCategoriaIdAndStatus(
    		             @PathVariable long categoriaId,
    		             @RequestParam int status,
    		             @RequestParam Boolean visiblePage,
    		             @RequestParam(defaultValue = "0") int page,
    		     		 @RequestParam(defaultValue = "10") int size,
    		     		 @RequestParam(defaultValue = "nombre") String order,
    		     		 @RequestParam(defaultValue = "true") boolean asc
    		     		){
    	return new ResponseEntity<>(productoService.listProductosByCategorialIdAndStatus(categoriaId,status,visiblePage,PageRequest.of(page, size,Sort.by(order))),HttpStatus.OK);
    }
    
    @GetMapping("/productos/like")
    public ResponseEntity<Page<ProductoDto>> getProductosByNombreLike(
    		              @RequestParam String nombre,
    		              @RequestParam int status,
    		              @RequestParam Boolean visiblePage,
      		              @RequestParam(defaultValue = "0") int page,
     		     		  @RequestParam(defaultValue = "10") int size,
     		     		  @RequestParam(defaultValue = "nombre") String order,
     		     		  @RequestParam(defaultValue = "true") boolean asc
    		              ){
    	Sort sort = Sort.by(order);
    	if(!asc)
    	   sort = Sort.by(order).descending();
    	return new ResponseEntity<>(productoService.listProductosByNombreLikeAndStatus(nombre,status,visiblePage,PageRequest.of(page, size ,sort)),HttpStatus.OK);
    }
      
      
    
    

}
