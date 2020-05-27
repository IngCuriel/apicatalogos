package com.curiel.catalogos.model.entity;

import java.io.Serializable; 
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Table(name="forma_de_pago")
@Data
public class FormaDePago implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String nombre;
	
 	@OneToMany(fetch = FetchType.EAGER, mappedBy="formaDePago") 
    private Set<MovimientoFormaPago> movimientoFormaPago;
    
}
