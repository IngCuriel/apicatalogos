package com.curiel.catalogos.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
 
import com.curiel.catalogos.util.GenericDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ProductoDto extends GenericDto implements Serializable{   
    /**
     * 
     */
    private static final long serialVersionUID = -1;
    String nombre;
    String decripcion;
    BigDecimal precio;
    BigDecimal costo;
    String imagen;
    private SucursalDto sucursal;
    private CategoriaDto categoria;
    private UnidadMedidaDto unidadMedida;


    
}
