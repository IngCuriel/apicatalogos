package com.curiel.catalogos.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.curiel.catalogos.util.GenericEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Status extends GenericEntity  implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    @Column(nullable=true,unique=true)
    private String descripcion;
    
    
}
