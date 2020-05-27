package com.curiel.catalogos.model.dto;

import java.io.Serializable;
import java.util.Set;

import com.curiel.catalogos.model.entity.MovimientoFormaPago;

import lombok.Data;

@Data
public class FormaDePagoDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1845637893892374484L;
	
	private Long id;
    private String nombre;
    private Set<MovimientoFormaPago> movimientoFormaPago;
}
