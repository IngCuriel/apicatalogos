package com.curiel.catalogos.model.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CategoriaDto implements Serializable{
    /**
     */
    private static final long serialVersionUID = 1L;
     
    private Long id;
    
    private String descripcion;
    
    private int status;
    
    private Set<CategoriaDto> categorias;
    
}
