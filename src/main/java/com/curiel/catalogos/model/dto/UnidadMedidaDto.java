package com.curiel.catalogos.model.dto;

import java.io.Serializable;

import com.curiel.catalogos.model.entity.Sucursal;
import com.curiel.catalogos.util.FechaDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UnidadMedidaDto extends FechaDto implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 697918629628121210L;
    
    Long id;
    String clave;
    String descripcion;
    private Sucursal sucursal; 
    
   
}
