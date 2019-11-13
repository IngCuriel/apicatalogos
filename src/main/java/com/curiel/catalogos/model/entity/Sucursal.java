package com.curiel.catalogos.model.entity;
import java.io.Serializable;

import javax.persistence.Entity; 

import com.curiel.catalogos.util.GenericEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Sucursal extends GenericEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8500440720002456865L;
	/**
     * 
     */
    
    String nombre;
    String descripcion; 
    String contacto;
    String redSocial;
    int meGusta;
    String logo;
     
    
}
