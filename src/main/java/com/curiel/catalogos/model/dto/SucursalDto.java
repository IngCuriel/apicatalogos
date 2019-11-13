package com.curiel.catalogos.model.dto;

import java.io.Serializable;


import com.curiel.catalogos.util.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class SucursalDto extends GenericDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1;
    
    String nombre;
    String descripcion; 
    String contacto;
    String redSocial;
    int meGusta;
    String logo;

        
}
