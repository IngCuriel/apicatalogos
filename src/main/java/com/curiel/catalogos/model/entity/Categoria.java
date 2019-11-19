package com.curiel.catalogos.model.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.curiel.catalogos.util.GenericEntity;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Categoria implements Serializable{
    /**
     * 
    */
     private static final long serialVersionUID = 1L;
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
     
     private String descripcion;
     
     @Column(nullable=true)
     private int status;
     
     @NotNull
     @OneToMany(fetch = FetchType.EAGER)
     private Set<Categoria> categorias;
      
}
