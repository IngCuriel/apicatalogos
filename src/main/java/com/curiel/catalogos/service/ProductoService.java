package com.curiel.catalogos.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.curiel.catalogos.model.dto.ProductoDto;
import com.curiel.catalogos.model.entity.Producto;
import com.curiel.catalogos.repository.ProductoRepository;
import com.curiel.catalogos.util.GenericService;

@Service
public class ProductoService implements GenericService<ProductoDto, Producto, Long>  {
  
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    @Transactional(readOnly=true)
    public Set<ProductoDto> list() {
        Set<ProductoDto> productoDtolist=new HashSet<>();
        productoRepository.findAll().forEach(producto->productoDtolist.add(convertDto(producto)));
         return productoDtolist;
    }

    @Override
    @Transactional
    public void delete(Long id) {
         productoRepository.deleteById(id);
     }

    @Override
    @Transactional
    public ProductoDto save(ProductoDto dto) {
         Producto producto=productoRepository.save(convertToEntity(dto));
         return convertToDto(producto);
    }

    @Override
    @Transactional(readOnly=true)
    public ProductoDto getById(Long id) {
         Producto producto=productoRepository.getOne(id);
         return convertToDto(producto);
    }
    
    @Transactional(readOnly = true)
    public Page<ProductoDto> listProductosByStatus(int status,Boolean visiblePage,Pageable pageable){
	    	List<ProductoDto> productosDtoList= new ArrayList<>();
	    	Page<Producto> productos;
	    	if(Boolean.TRUE.equals(visiblePage)) {
	    		productos=productoRepository.findByStatusAndVisiblePage(status, visiblePage,pageable);
	    	}else {
	    		productos=productoRepository.findByStatus(status,pageable);
	    	}
	    	productos.getContent().forEach(productoscontent-> productosDtoList.add(convertDto(productoscontent)));
	        return new PageImpl<>(productosDtoList,pageable,productos.getTotalElements());
    }

    
    @Transactional(readOnly = true)
    public Page<ProductoDto> listProductosBySucursalIdAndStatus(Long sucursalId,int status, Boolean visiblePage,Pageable pageable){
	        List<ProductoDto> productoDtolist=new ArrayList<>();
	        Page<Producto> productos;
	        if(Boolean.TRUE.equals(visiblePage)) {
	        	productos=productoRepository.findBySucursalIdAndStatusAndVisiblePage(sucursalId, status, visiblePage, pageable);
	        }else {
	        	productos=productoRepository.findBySucursalIdAndStatus(sucursalId, status, pageable);
	        }
	        productos.getContent().forEach(productoscontent->productoDtolist.add(convertDto(productoscontent)));
	        return new PageImpl<>(productoDtolist, pageable,productos.getTotalElements());
    }
    
    
	@Transactional(readOnly = true)
    public Page<ProductoDto> listProductosByCategorialIdAndStatus(Long categoriaId,int status,Boolean visiblePage,Pageable pageable){
            List<ProductoDto> productoDtolist=new ArrayList<>();
            Page<Producto> productos;
            if(Boolean.TRUE.equals(visiblePage)) {
         	   productos=productoRepository.findByCategoriaIdAndStatusAndVisiblePage(categoriaId,status,visiblePage,pageable);
            }else {
        	   productos=productoRepository.findByCategoriaIdAndStatus(categoriaId,status,pageable);
            }
            productos.getContent().forEach(productoscontent->productoDtolist.add(convertDto(productoscontent)));
            return new PageImpl<>(productoDtolist,pageable, productos.getTotalElements());
    }
     
	
    @Transactional(readOnly = true)
    public Page<ProductoDto> listProductosByNombreLikeAndStatus(String nombre,int status,Boolean visiblePage,Pageable pageable){
        List<ProductoDto> productoDtolist=new ArrayList<>();
        Page<Producto> productos;
        if(Boolean.TRUE.equals(visiblePage)) {
        	productos = productoRepository.findByNombreContainingOrDescripcionContainingAndStatusAndVisiblePage(nombre,nombre, status, visiblePage, pageable);
        }else {
        	productos =productoRepository.findByNombreContainingOrDescripcionContainingAndStatus(nombre,nombre, status, pageable);
        }
        productos.getContent().forEach(productoscontent->productoDtolist.add(convertDto(productoscontent)));
        return  new PageImpl<>(productoDtolist,pageable,productos.getTotalElements());
    }
    
    @Override
    public ProductoDto convertToDto(Producto entity) {
         return modelMapper.map(entity, ProductoDto.class);
    }

    @Override
    public Producto convertToEntity(ProductoDto dto) {
         return modelMapper.map(dto, Producto.class);
    }
    
    public ProductoDto convertDto(Producto entity) {
    	ProductoDto dto=new ProductoDto();
    	dto.setId(entity.getId());
    	dto.setNombre(entity.getNombre());
    	dto.setDescripcion(entity.getDescripcion());
    	dto.setPrecio(entity.getPrecio());
    	dto.setImagen(entity.getImagen());
    	dto.setVisiblePage(entity.getVisiblePage());
        return dto;
    }
  
  
}
