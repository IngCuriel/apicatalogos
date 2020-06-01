package com.curiel.catalogos.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curiel.catalogos.model.dto.ReferenciaPagoDto;
import com.curiel.catalogos.model.entity.FormaDePago;
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
		FormaDePago formaDePago=new FormaDePago();
		formaDePago.setId(id);
		List<Object[]> setObject=referenciaPagoRepository.findByFormaDePago(formaDePago);
		for(Object[] ob:setObject) { 
		  referenciaPagoList.add(convertObjectToDto(ob));
		}
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
	
	public ReferenciaPagoDto convertObjectToDto(Object[] entity) {
		ReferenciaPagoDto referenciaPagoDto=new ReferenciaPagoDto();
		referenciaPagoDto.setId((long) entity[0]);
		referenciaPagoDto.setDecripcion(entity[1].toString());
		referenciaPagoDto.setNumeroCuenta(entity[2].toString());
		return referenciaPagoDto;
	}

	@Override
	public ReferenciaPago convertToEntity(ReferenciaPagoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
