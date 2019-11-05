package com.curiel.catalogos.service;

import java.util.HashSet;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.curiel.catalogos.model.dto.SucursalDto;
import com.curiel.catalogos.model.entity.Sucursal;
import com.curiel.catalogos.repository.SucursalRepository;
import com.curiel.catalogos.util.GenericService;
 
@Service
public class SucursalService implements GenericService<SucursalDto, Sucursal, Long>{
    
      @Autowired
      private SucursalRepository sucursalRepository;
      
      @Autowired
      private ModelMapper modelMapper;
           
       @Override
       @Transactional(readOnly=true)
        public Set<SucursalDto> list() {
          Set<SucursalDto> sucursalDtoList= new HashSet<>(); 
          sucursalRepository.findAll().forEach(sucursal->sucursalDtoList.add(convertToDto(sucursal)));
          return sucursalDtoList;
        }
        
        @Override
        @Transactional
        public void delete(Long id) {
             sucursalRepository.deleteById(id);
         }
        
        @Override
        @Transactional
        public SucursalDto save(SucursalDto dto) {
             Sucursal sucursal=sucursalRepository.save(convertToEntity(dto));
             return convertToDto(sucursal);
        }
        
        @Override
        @Transactional(readOnly=true)
        public SucursalDto getById(Long id) {
            Sucursal sucursal= sucursalRepository.getOne(id);
             return convertToDto(sucursal);
        }
        
        @Override
        public SucursalDto convertToDto(Sucursal entity) {
             return modelMapper.map(entity, SucursalDto.class);
        }
        
        @Override
        public Sucursal convertToEntity(SucursalDto dto) {
             return modelMapper.map(dto, Sucursal.class);
        }
  
}
