package com.curiel.catalogos.model.entity.mercado.pago;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class NotificacionWebhooks implements Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private String  data;
}
