package com.curiel.catalogos.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
public class Producto extends GenericEntity implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    String nombre;
    
    String descripcion;
    
    BigDecimal precio;
    
    BigDecimal costo;
    
    String imagen;
    
    Boolean visiblePage;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Sucursal sucursal;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;
    
    @OneToOne(fetch = FetchType.EAGER)
    private UnidadMedida unidadMedida;
   
}
