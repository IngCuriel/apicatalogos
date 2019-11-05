package com.curiel.catalogos.service;

import java.util.HashSet;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.curiel.catalogos.model.dto.MovimientoDto;
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
    public MovimientoDto getByClienteProveedor(String clienteProveedor) {
        Movimiento movimiento= movimientoRepository.findByClienteProveedor(clienteProveedor);
        return convertToDto(movimiento);
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
