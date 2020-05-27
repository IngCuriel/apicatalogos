package com.curiel.catalogos.service;

import java.util.LinkedHashSet;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.curiel.catalogos.model.dto.FormaDePagoDto;
import com.curiel.catalogos.model.entity.FormaDePago;
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
         return  modelMapper.map(entity, FormaDePagoDto.class);
  }
  
  public FormaDePago convertToEntity(FormaDePagoDto dto) {
       return modelMapper.map(dto, FormaDePago.class);
  }
  
}
