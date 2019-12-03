package com.curiel.catalogos.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DetalleMov implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -1633710542518779310L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    BigDecimal cantidad;
    
    BigDecimal costoUnitario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;
    
     

}
