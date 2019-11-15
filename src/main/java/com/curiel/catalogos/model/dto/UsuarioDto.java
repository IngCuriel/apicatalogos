package com.curiel.catalogos.model.dto;

import com.curiel.catalogos.emun.TipoUsuario;

import lombok.Data;

@Data
public class UsuarioDto { 
	
	    private Long id;     
	    private String username;
	    private String email;
 	    private String password;
	    private Boolean enabled;
	    private TipoUsuario tipousuario;
	    private long sucursalid;

}
