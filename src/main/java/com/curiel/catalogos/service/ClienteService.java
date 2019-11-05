package com.curiel.catalogos.service;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.curiel.catalogos.model.dto.ClienteDto;
import com.curiel.catalogos.model.entity.Cliente;
import com.curiel.catalogos.repository.ClienteRepository;
import com.curiel.catalogos.util.GenericService;

@Service
public class ClienteService implements GenericService<ClienteDto,Cliente, Long> {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    @Transactional(readOnly=true)
    public Set<ClienteDto> list() {
        Set<ClienteDto> clienteDtoSet=new HashSet<>(); 
        clienteRepository.findAll().forEach(cliente-> clienteDtoSet.add(new ClienteDto(cliente.getId(), cliente.getName(),cliente.getEmail())));
        return clienteDtoSet;
    }

    @Override
    @Transactional
    public void delete(Long id) {
         clienteRepository.deleteById(id);        
    }

    @Override
    @Transactional
    public ClienteDto save(ClienteDto dto) {
        Cliente cliente=clienteRepository.save(convertToEntity(dto));
         return convertToDto(cliente);
    }

    @Override
    @Transactional(readOnly=true)
    public ClienteDto getById(Long id) {
        Cliente cliente = clienteRepository.getOne(id);
         return convertToDto(cliente);
    }

    @Override
    public ClienteDto convertToDto(Cliente entity) {
           return  modelMapper.map(entity, ClienteDto.class);
    }

    @Override
    public Cliente convertToEntity(ClienteDto dto) {
         return modelMapper.map(dto, Cliente.class);
    }
    
    
 
}
