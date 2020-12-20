package com.curiel.catalogos.service.mercado.pago;

import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.curiel.catalogos.model.dto.mercado.pago.NotificacionWebhooksDto;
import com.curiel.catalogos.model.entity.mercado.pago.NotificacionWebhooks;
import com.curiel.catalogos.repository.mercado.pago.NotificacionWebhooksRepository;
import com.curiel.catalogos.util.GenericService;

@Service
public class NotificacionWebhooksService implements GenericService<NotificacionWebhooksDto, NotificacionWebhooks, Integer>  {
 
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private NotificacionWebhooksRepository notificacionWebhooksRepository;
 	
	@Transactional(readOnly = true)
	@Override
	public Set<NotificacionWebhooksDto> list() {
		return notificacionWebhooksRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toSet());
	}

	@Override
	public void delete(Integer id) {		
	}

	@Transactional
	@Override
	public NotificacionWebhooksDto save(NotificacionWebhooksDto dto) {
		
		NotificacionWebhooks notifiacaiones = notificacionWebhooksRepository.save(convertToEntity(dto));
		return convertToDto(notifiacaiones);
	}

	@Override
	public NotificacionWebhooksDto getById(Integer id) {
		return null;
	}

	@Override
	public NotificacionWebhooksDto convertToDto(NotificacionWebhooks entity) {
		return modelMapper.map(entity, NotificacionWebhooksDto.class);
	}

	@Override
	public NotificacionWebhooks convertToEntity(NotificacionWebhooksDto dto) {
 		return modelMapper.map(dto, NotificacionWebhooks.class);
	}

}
