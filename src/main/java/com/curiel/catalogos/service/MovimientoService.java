package com.curiel.catalogos.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curiel.catalogos.model.dto.DetalleMovDto;
import com.curiel.catalogos.model.dto.MovimientoDto;
import com.curiel.catalogos.model.dto.ProductoDto;
import com.curiel.catalogos.model.entity.DetalleMov;
import com.curiel.catalogos.model.entity.Movimiento;
import com.curiel.catalogos.repository.MovimientoRepository;
import com.curiel.catalogos.util.GenericService;

 
@Service
public class MovimientoService implements GenericService<MovimientoDto, Movimiento, Long>{
  @Autowired
  private MovimientoRepository movimientoRepository;
  
  @Autowired
  private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly=true)
    public Set<MovimientoDto> list() {
        Set<MovimientoDto> movimientoDtoList= new HashSet<>();
        movimientoRepository.findAll().forEach(movimiento->movimientoDtoList.add(convertToDto(movimiento)));
        return movimientoDtoList;
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
         movimientoRepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public MovimientoDto save(MovimientoDto dto) {
        Movimiento movimiento=movimientoRepository.save(convertToEntity(dto));
         return convertToDto(movimiento);
    }
    
    @Override
    @Transactional(readOnly=true)
    public MovimientoDto getById(Long id) {
         Movimiento movimiento=movimientoRepository.getOne(id);
         return convertToDto(movimiento);
    }
    
    @Transactional(readOnly=true)
    public List<MovimientoDto> getByClienteProveedor(String clienteProveedor) {
    	List<MovimientoDto> movimientoDtoList=new ArrayList<>();
        List<Movimiento> movimientos= movimientoRepository.findByClienteProveedor(clienteProveedor);
        MovimientoDto movimientoDto;
        ProductoDto producto=new ProductoDto();
        for(Movimiento movimiento:movimientos) {
        	movimientoDto = new MovimientoDto();
            movimientoDto.setId(movimiento.getId());
            movimientoDto.setCreateAt(movimiento.getCreateAt());
            movimientoDto.setClienteProveedor(movimiento.getClienteProveedor());
            movimientoDto.setDescripcion(movimiento.getDescripcion());
            Set<DetalleMovDto> detalleMovDtoList=new HashSet();
            DetalleMovDto detalleMovDto ;
            for(DetalleMov detalle:movimiento.getDetallesMov()) {
            	detalleMovDto =new DetalleMovDto();
            	detalleMovDto.setId(detalle.getId());
            	detalleMovDto.setCantidad(detalle.getCantidad());
            	detalleMovDto.setImporte(detalle.getImporte());
                
            	ProductoDto productoDto=new ProductoDto();
            	productoDto.setId(detalle.getProducto().getId());
            	productoDto.setNombre(detalle.getProducto().getNombre());
            	detalleMovDto.setProducto(productoDto);
            	detalleMovDtoList.add(detalleMovDto);
            }
            movimientoDto.setDetallesMov(detalleMovDtoList);
            movimientoDto.setObservacion(movimiento.getObservacion());
            movimientoDto.setTotal(movimiento.getTotal());
            movimientoDtoList.add(movimientoDto);
        }
        return movimientoDtoList;
    }
    
    @Override
    public MovimientoDto convertToDto(Movimiento entity) {
         return modelMapper.map(entity, MovimientoDto.class);
    }
    
    @Override
    public Movimiento convertToEntity(MovimientoDto dto) {
         return modelMapper.map(dto, Movimiento.class);
    }
    
   
}
