package com.curiel.catalogos.util;

import java.util.Date;
import com.curiel.catalogos.model.entity.Status;
import com.curiel.catalogos.model.entity.Usuario;
import lombok.Data;
 

@Data
public abstract class GenericDto {
   
     /**
     * 
     */
    private long id;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Usuario usuario;
    private int status;
    
 
}
