package com.curiel.catalogos.service;

import java.util.LinkedHashSet;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.curiel.catalogos.model.dto.FormaDePagoDto;
import com.curiel.catalogos.model.dto.ReferenciaPagoDto;
import com.curiel.catalogos.model.entity.FormaDePago;
import com.curiel.catalogos.model.entity.ReferenciaPago;
import com.curiel.catalogos.repository.FormaDePagoRepository;

@Service
public class FormaDePagoService {
	
  @Autowired
  private FormaDePagoRepository formaDePagoRepository;
  
  @Autowired
  private ModelMapper modelMapper;
  
   
  @Transactional(readOnly=true)
  public Set<FormaDePagoDto>  list(){
	  Set<FormaDePagoDto>  formaDePagoList=new LinkedHashSet<>();
	  formaDePagoRepository.findAll().forEach(formapgo->formaDePagoList.add(convertToDto(formapgo)));
	  return formaDePagoList;
  }
  @Transactional
  public FormaDePagoDto save(FormaDePagoDto dto) {
	    FormaDePago formaDePago=formaDePagoRepository.save(convertToEntity(dto));
	    return convertToDto(formaDePago);
  }
  
  public FormaDePagoDto convertToDto(FormaDePago entity) {
	  FormaDePagoDto formaDePagoDto = new FormaDePagoDto();
	    formaDePagoDto.setId(entity.getId());
	    formaDePagoDto.setNombre(entity.getNombre());
	    Set<ReferenciaPagoDto> referenciaPagoDtoList=new LinkedHashSet<>();
	    //entity.getReferenciaPago().forEach(referencia-> referenciaPagoDtoList.add(converToDtoReferencia(referencia)));
	    //formaDePagoDto.setReferenciaPago(referenciaPagoDtoList);
        return  formaDePagoDto;
  }
  
  public FormaDePago convertToEntity(FormaDePagoDto dto) {
       return modelMapper.map(dto, FormaDePago.class);
  }
  /*
  public ReferenciaPagoDto converToDtoReferencia(ReferenciaPago entity) {
	  System.out.println(entity);
	  ReferenciaPagoDto referenciaPagoDto = new ReferenciaPagoDto();
	  referenciaPagoDto.setId(entity.getId());
	  referenciaPagoDto.setDecripcion(entity.getDecripcion());
	  referenciaPagoDto.setNumeroCuenta(entity.getNumeroCuenta());
	  return referenciaPagoDto;
  }*/
  
}
