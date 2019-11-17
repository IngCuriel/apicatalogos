package com.curiel.catalogos.service;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curiel.catalogos.model.dto.UsuarioDto;
import com.curiel.catalogos.model.entity.Usuario;
import com.curiel.catalogos.repository.UsuarioRepository;
import com.curiel.catalogos.util.GenericService;

@Service
public class UsuarioService implements GenericService<UsuarioDto, Usuario, Long>{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper modelMapper; 
	 
	@Override
	@Transactional(readOnly=true)
	public Set<UsuarioDto> list() {
		Set<UsuarioDto> listUsuario=new HashSet<>();
		usuarioRepository.findAll().forEach(usuario -> listUsuario.add(convertToDto(usuario)));
 		return listUsuario;
	}

	@Override
 	@Transactional(readOnly=true)
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	@Transactional
	public UsuarioDto save(UsuarioDto dto) {
		Usuario usuario=usuarioRepository.save(convertToEntity(dto)); 
 		return convertToDto(usuario);
	}

	@Override
	@Transactional(readOnly=true)
	public UsuarioDto getById(Long id) {
		Usuario usuario=usuarioRepository.getOne(id);
 		return convertToDto(usuario);
	}
	
	@Transactional(readOnly=true)
	public UsuarioDto getByEmail(String email) {
		Usuario usuario=usuarioRepository.findByEmail(email);
 		return convertToDto(usuario);
	}

	@Override
	public UsuarioDto convertToDto(Usuario entity) {
		return modelMapper.map(entity, UsuarioDto.class);
	}

	@Override
	public Usuario convertToEntity(UsuarioDto dto) {
		return modelMapper.map(dto,Usuario.class);
	}

}
