package com.curiel.catalogos.model.dto;

import com.curiel.catalogos.util.GenericDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CategoriaDto extends GenericDto {
    /**
     * 
    */
    private static final long serialVersionUID = 1L;
    private String descripcion;
    
}
