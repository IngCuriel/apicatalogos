package com.curiel.catalogos.model.entity;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    
    String nombre;
    
    String descripcion;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="sucursal_producto" ,joinColumns=@JoinColumn(name="sucursal_id"),inverseJoinColumns=@JoinColumn(name="producto_id"))
    Set<Producto> productos;
    
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }
    
}
