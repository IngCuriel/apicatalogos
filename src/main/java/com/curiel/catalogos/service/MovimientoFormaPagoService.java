package com.curiel.catalogos.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curiel.catalogos.model.dto.MovimientoFormaPagoDto;
import com.curiel.catalogos.model.entity.FormaDePago;
import com.curiel.catalogos.model.entity.Movimiento;
import com.curiel.catalogos.model.entity.MovimientoFormaPago;
import com.curiel.catalogos.repository.MovimientoFormaPagoRepository;
import com.curiel.catalogos.util.GenericService;

@Service
public class MovimientoFormaPagoService implements GenericService<MovimientoFormaPagoDto, MovimientoFormaPago, Long>{
    
	@Autowired
    private MovimientoFormaPagoRepository movimientoFormaPagoRepository;
	
    @Override
    @Transactional(readOnly=true)
	public Set<MovimientoFormaPagoDto> list() {
		Set<MovimientoFormaPagoDto> movimientoFPSet=new LinkedHashSet<>();
		movimientoFormaPagoRepository.findAll().forEach(pagos->movimientoFPSet.add(convertToDto(pagos)));
		return movimientoFPSet;
	}
    
    @Transactional(readOnly=true)
  	public Set<MovimientoFormaPagoDto> findByMovimientoId(Long id) {
  		Set<MovimientoFormaPagoDto> movimientoFPSet=new LinkedHashSet<>();
  		Movimiento movimiento=new Movimiento();
  		movimiento.setId(id);
  		movimientoFormaPagoRepository.findByMovimiento(movimiento).forEach(pagos->movimientoFPSet.add(convertToDto(pagos)));
  		return movimientoFPSet;
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
		MovimientoFormaPagoDto movimientoFormaPagoDto=new MovimientoFormaPagoDto();
		movimientoFormaPagoDto.setId(entity.getId());
		movimientoFormaPagoDto.setPago(entity.getPago());
		movimientoFormaPagoDto.setDescripcionPago(entity.getDescripcionPago());
		movimientoFormaPagoDto.setComprobantePago(entity.getComprobantePago());
		FormaDePago formaDePago=new FormaDePago();
		formaDePago.setNombre(entity.getFormaDePago().getNombre());
		formaDePago.setId(entity.getFormaDePago().getId());
		movimientoFormaPagoDto.setFormaDePago(formaDePago);
		return movimientoFormaPagoDto;
	}

	@Override
	public MovimientoFormaPago convertToEntity(MovimientoFormaPagoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

 

}
