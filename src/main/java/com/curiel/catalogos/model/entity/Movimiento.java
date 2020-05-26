package com.curiel.catalogos.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.curiel.catalogos.emun.StatusMovimiento;

import lombok.Data;

@Entity
@Data
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String descripcion;

    String observacion;

    String clienteProveedor;
   
    BigDecimal total;
    
    private String system;
    
    private StatusMovimiento status; 
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "detalle_mov_id")
    private Set<DetalleMov> detallesMov;
    
    
    @Column(name = "fecha_creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    
    @Column(name = "fecha_actualizado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdated;
    
    @PrePersist
    public void prePersist() {
        this.dateCreated = new Date();
    }
    

    @PreUpdate
    public void uploadPersist() {
        this.dateUpdated = new Date();
    }
    
}
