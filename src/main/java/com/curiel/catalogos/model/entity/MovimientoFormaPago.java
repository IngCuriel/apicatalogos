package com.curiel.catalogos.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MovimientoFormaPago implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8532290837089129538L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	/**
	 * Importe a pagar por el metodo de pago
	 */
	private BigDecimal pago;
	
	@ManyToOne
    private Movimiento movimiento;

    @ManyToOne 
    private FormaDePago formaDePago;
}
