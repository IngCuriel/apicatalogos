package com.curiel.catalogos.service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curiel.catalogos.model.dto.ReferenciaPagoDto;
import com.curiel.catalogos.model.entity.ReferenciaPago;
import com.curiel.catalogos.repository.ReferenciaPagoRepository;
import com.curiel.catalogos.util.GenericService;

@Service
public class ReferenciaPagoService implements GenericService<ReferenciaPagoDto, ReferenciaPago, Long>{
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ReferenciaPagoRepository referenciaPagoRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public Set<ReferenciaPagoDto> list() {
		Set<ReferenciaPagoDto> referenciaPagoList= new  LinkedHashSet<>();
		 referenciaPagoRepository.findAll().forEach(referencia-> referenciaPagoList.add(convertToDto(referencia)));
		return referenciaPagoList;
	}
	
	@Transactional(readOnly = true)
	public Set<ReferenciaPagoDto> findByFormaDePagoId(Long id) {
		Set<ReferenciaPagoDto> referenciaPagoList= new  LinkedHashSet<>();
		 referenciaPagoRepository.findByFormaDePagoId(id).forEach(referencia-> referenciaPagoList.add(convertToDto(referencia)));
		return referenciaPagoList;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReferenciaPagoDto save(ReferenciaPagoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReferenciaPagoDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReferenciaPagoDto convertToDto(ReferenciaPago entity) {
		ReferenciaPagoDto referenciaPagoDto=new ReferenciaPagoDto();
		referenciaPagoDto.setId(entity.getId());
		referenciaPagoDto.setDecripcion(entity.getDecripcion());
		referenciaPagoDto.setNumeroCuenta(entity.getNumeroCuenta());
		return referenciaPagoDto;
	}

	@Override
	public ReferenciaPago convertToEntity(ReferenciaPagoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
