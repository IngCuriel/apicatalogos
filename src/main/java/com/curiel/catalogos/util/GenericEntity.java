package com.curiel.catalogos.util;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.curiel.catalogos.model.entity.Status;
import com.curiel.catalogos.model.entity.Usuario;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class GenericEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @OneToOne(fetch=FetchType.EAGER)
    private Usuario usuario;

    @OneToOne(fetch=FetchType.EAGER)
    private Status status;
    
    @PrePersist
    public void prePersist() {
        this.fechaCreacion = new Date();
    }
  
    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion=new Date();
    }
}
