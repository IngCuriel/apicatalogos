package com.curiel.catalogos.model.dto.mercado.pago;

import java.io.Serializable;
import lombok.Data;

@Data
public class NotificacionWebhooksDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Boolean live_mode;
	private String  type;
	private String  date_created;
	private Integer application_id;
	private Integer user_id;
	private Integer version;
	private String  api_version;
	private String  action;
	private Object  data;
}
