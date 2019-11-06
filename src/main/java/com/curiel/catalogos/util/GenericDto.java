package com.curiel.catalogos.util;

import java.io.Serializable;
import java.util.Date;

import com.curiel.catalogos.model.entity.Status;
import com.curiel.catalogos.model.entity.Usuario;

import lombok.Data;
 

@Data
public abstract class GenericDto implements Serializable {
   
     /**
     * 
     */
    private static final long serialVersionUID = -7034798479755984405L;
    private long id;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Usuario usuario;
    private Status status;
    
 
}
