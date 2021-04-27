package com.curiel.catalogos.controller.mercado.pago;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.curiel.catalogos.model.dto.mercado.pago.NotificacionWebhooksDto;
import com.curiel.catalogos.service.mercado.pago.NotificacionWebhooksService;

@RestController
@RequestMapping("api/v1/mercado.pago/notificaciones")
public class NotificacionWMercadoPagoController {
    
	@Autowired
	private NotificacionWebhooksService notificacionWebhooksService;
	
	/**
	 *  <p>
	 *    Es método tiene como objetivo exponer un servicio REST POST para recibie notificacines
	 *    de mercado pago para el serguimientos de los pagos
	 *  </p>
	 * @param notificacion 
	 * @return
	 */
	
	@PostMapping
	public ResponseEntity<NotificacionWebhooksDto> obtener(@RequestBody NotificacionWebhooksDto notificacion) {
		NotificacionWebhooksDto responseNotifiacion = notificacionWebhooksService.save(notificacion);
		return new ResponseEntity<>(responseNotifiacion, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Set<NotificacionWebhooksDto>> list() {
		Set<NotificacionWebhooksDto> notificacines = notificacionWebhooksService.list();
		return new ResponseEntity<>(notificacines, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		 notificacionWebhooksService.deleteNotificacion(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
}
