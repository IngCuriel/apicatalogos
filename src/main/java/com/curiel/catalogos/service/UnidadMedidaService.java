package com.curiel.catalogos.service;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curiel.catalogos.model.dto.UnidadMedidaDto;
import com.curiel.catalogos.model.entity.UnidadMedida;
import com.curiel.catalogos.repository.UnidadMedidaRepository;
import com.curiel.catalogos.util.GenericService;

@Service
public class UnidadMedidaService implements GenericService<UnidadMedidaDto, UnidadMedida, Long>{

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;
    
    @Autowired
    private ModelMapper modelMapper; 
    
    @Override
    @Transactional(readOnly=true)
    public Set<UnidadMedidaDto> list() {
        Set<UnidadMedidaDto> unidadMedidaList=new HashSet<>();
        unidadMedidaRepository.findAll().forEach(unidadMedida->unidadMedidaList.add(convertToDto(unidadMedida)));
        return unidadMedidaList;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        unidadMedidaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UnidadMedidaDto save(UnidadMedidaDto dto) {
         UnidadMedida unidadMedida= unidadMedidaRepository.save(convertToEntity(dto));
         return convertToDto(unidadMedida);
    }

    @Override
    @Transactional(readOnly=true)
    public UnidadMedidaDto getById(Long id) {
         UnidadMedida unidadMedida=unidadMedidaRepository.getOne(id);
         return convertToDto(unidadMedida);
    }
    
    
    
    @Transactional
    public int updateStatus(Long id,Long statusId) {
       return unidadMedidaRepository.updateStatusId(id,statusId);
    }
    
    @Override
    public UnidadMedidaDto convertToDto(UnidadMedida entity) {
        return modelMapper.map(entity, UnidadMedidaDto.class);
    }

    @Override
    public UnidadMedida convertToEntity(UnidadMedidaDto dto) {
         return modelMapper.map(dto, UnidadMedida.class);
    }
}
