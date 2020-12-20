package com.curiel.catalogos.model.dto.mercado.pago;

import java.io.Serializable;
import lombok.Data;

@Data
public class NotificacionWebhooksDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long notificacionId; 
	
	private Long id;
	private Boolean live_mode;
	private String  type;
	private String  date_created;
	private Long application_id;
	private Long user_id;
	private Long version;
	private String  api_version;
	private String  action;
	private Object  data;
}
