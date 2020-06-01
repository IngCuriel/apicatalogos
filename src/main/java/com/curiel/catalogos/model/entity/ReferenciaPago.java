package com.curiel.catalogos.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReferenciaPago implements Serializable{
	
  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6925051557150199406L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;
    private String decripcion;
    private String numeroCuenta;
    
    @ManyToOne
    private FormaDePago formaDePago;

}
