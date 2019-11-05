package com.curiel.catalogos.service;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curiel.catalogos.model.dto.DetalleMovDto;
import com.curiel.catalogos.model.entity.DetalleMov;
import com.curiel.catalogos.repository.DetalleMovRepository;
import com.curiel.catalogos.util.GenericService;

@Service
public class DetalleMovService implements GenericService<DetalleMovDto,DetalleMov, Long>{
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private DetalleMovRepository detalleMovRepository;
    
    @Override
    public Set<DetalleMovDto> list() {
        return null;
    }

    @Override
    public void delete(Long id) {
     }

    @Override
    @Transactional
    public DetalleMovDto save(DetalleMovDto dto) {
        DetalleMov detalleMov= detalleMovRepository.save(convertToEntity(dto));
        return convertToDto(detalleMov);
    }

    @Override
    public DetalleMovDto getById(Long id) {
        return null;
    }

    @Override
    public DetalleMovDto convertToDto(DetalleMov entity) {
        return modelMapper.map(entity, DetalleMovDto.class);
    }

    @Override
    public DetalleMov convertToEntity(DetalleMovDto dto) {
         return modelMapper.map(dto, DetalleMov.class);
    }
    
}
