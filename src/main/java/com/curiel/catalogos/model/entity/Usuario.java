package com.curiel.catalogos.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import com.curiel.catalogos.emun.TipoUsuario;
import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
public class Usuario implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique=true,length=250)
    private String username;
    
    @NotNull
    @Email
    @Column(unique=true)
    private String email;
    
    @Column(length=60)
    private String password;
    
    private Boolean enabled;
    
    private TipoUsuario tipousuario;
    
    @Column(nullable=true)
    private long sucursalid;
}
