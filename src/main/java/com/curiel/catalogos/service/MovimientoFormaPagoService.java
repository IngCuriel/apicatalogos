package com.curiel.catalogos.service;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.curiel.catalogos.model.dto.MovimientoFormaPagoDto;
import com.curiel.catalogos.model.entity.MovimientoFormaPago;
import com.curiel.catalogos.util.GenericService;

public class MovimientoFormaPagoService implements GenericService<MovimientoFormaPagoDto, MovimientoFormaPago, Long>{

	@Override
	public Set<MovimientoFormaPagoDto> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MovimientoFormaPagoDto save(MovimientoFormaPagoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public MovimientoFormaPagoDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovimientoFormaPagoDto convertToDto(MovimientoFormaPago entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovimientoFormaPago convertToEntity(MovimientoFormaPagoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

 

}
