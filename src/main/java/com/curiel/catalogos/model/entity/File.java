package com.curiel.catalogos.model.entity;

import javax.persistence.Entity;

import com.curiel.catalogos.util.GenericEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class File extends GenericEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String url;
}
