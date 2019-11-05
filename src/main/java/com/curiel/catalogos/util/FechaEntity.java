package com.curiel.catalogos.util;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class FechaEntity implements Serializable {
   
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = new Date();
    }
  
    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion=new Date();
    }
}
