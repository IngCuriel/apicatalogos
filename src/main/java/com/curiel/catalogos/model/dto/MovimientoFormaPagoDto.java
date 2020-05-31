package com.curiel.catalogos.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.curiel.catalogos.model.entity.FormaDePago;
import com.curiel.catalogos.model.entity.Movimiento;

import lombok.Data;

@Data
public class MovimientoFormaPagoDto implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2370594198448401926L;

	private Long id;
	 
	private BigDecimal pago;
	
	private String descripcionPago;
	
	private String comprobantePago;
	
    private Movimiento movimiento;

    private FormaDePago formaDePago;
}
