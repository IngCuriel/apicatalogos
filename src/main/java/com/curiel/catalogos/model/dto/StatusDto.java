package com.curiel.catalogos.model.dto;

import java.io.Serializable;

import com.curiel.catalogos.util.GenericDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class StatusDto extends GenericDto implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String descripcion;
}
