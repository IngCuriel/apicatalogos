package com.curiel.catalogos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import com.curiel.catalogos.util.GenericEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Categoria extends GenericEntity implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

     private String descripcion;
}
