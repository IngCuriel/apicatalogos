package com.curiel.catalogos.model.dto;
import java.io.Serializable;

import com.curiel.catalogos.model.entity.FormaDePago;

import lombok.Data;

@Data
public class ReferenciaPagoDto implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1336778025113348297L;
	
	private Long id;
    private String decripcion;
    private String numeroCuenta;
    
    private FormaDePago formaDePago;
 }
