package com.curiel.catalogos.model.entity;
import java.io.Serializable;
  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 

import com.curiel.catalogos.util.GenericEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Sucursal extends GenericEntity implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
   
    String nombre;
    String descripcion;
    String logo;
     
    
}
