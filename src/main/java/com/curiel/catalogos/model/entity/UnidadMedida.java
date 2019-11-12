package com.curiel.catalogos.model.entity;
 import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne; 
import com.curiel.catalogos.util.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class UnidadMedida  extends GenericEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    String clave;
    
    String descripcion;
     
    
    
  

}
