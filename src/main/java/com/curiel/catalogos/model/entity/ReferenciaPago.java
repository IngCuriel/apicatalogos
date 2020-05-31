package com.curiel.catalogos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ReferenciaPago implements Serializable{
	
   /**
	 * 
	*/
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;
    private String decripcion;
    private String numeroCuenta;
    
    @ManyToOne
    private FormaDePago formaDePago;

}
