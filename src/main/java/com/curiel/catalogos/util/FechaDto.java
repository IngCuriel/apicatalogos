package com.curiel.catalogos.util;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
 

@Data
public abstract class FechaDto implements Serializable {
   
     /**
     * 
     */
    private static final long serialVersionUID = -7034798479755984405L;
    
    private Date fechaCreacion;
     private Date fechaModificacion;

 
}
