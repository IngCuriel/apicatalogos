package com.curiel.catalogos.service;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.curiel.catalogos.model.dto.StatusDto;
import com.curiel.catalogos.model.entity.Status;
import com.curiel.catalogos.repository.StatusRepository;
import com.curiel.catalogos.util.GenericService;

@Service
public class StatusService implements GenericService<StatusDto,Status, Long>{

    @Autowired
    private StatusRepository statusRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    @Transactional(readOnly=true)
    public Set<StatusDto> list() {
        Set<StatusDto> statusDtoList=new HashSet<>();
        statusRepository.findAll().forEach(status->statusDtoList.add(convertToDto(status)));        
        return statusDtoList;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        statusRepository.deleteById(id);        
    }

    @Override
    @Transactional
    public StatusDto save(StatusDto dto) {
        Status status=statusRepository.save(convertToEntity(dto));
         return convertToDto(status);
    }

    @Override
    @Transactional(readOnly=true)
    public StatusDto getById(Long id) {
        Status status=statusRepository.getOne(id);
        return convertToDto(status);
    }

    @Override
    public StatusDto convertToDto(Status entity) {
         return modelMapper.map(entity, StatusDto.class);
    }

    @Override
    public Status convertToEntity(StatusDto dto) {
        return modelMapper.map(dto,Status.class);
    }
}
