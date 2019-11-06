package com.curiel.catalogos.model.dto;

import java.io.Serializable;

import com.curiel.catalogos.model.entity.Sucursal;
import com.curiel.catalogos.util.GenericDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UnidadMedidaDto extends GenericDto implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 697918629628121210L;
    
    String clave;
    String descripcion;
    private Sucursal sucursal; 
    
   
}
