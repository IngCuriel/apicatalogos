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
    String descripcion;
    String codigoBarras;
    BigDecimal precio;
    BigDecimal costo;
    String imagen;
    Boolean visiblePage;
    /**
    * Palabras claves para su busqueda
    */
    String palabrasClave;
    private SucursalDto sucursal;
    private CategoriaDto categoria;
    private UnidadMedidaDto unidadMedida;
    BigDecimal existencias;
    BigDecimal apartados;
    String observaciones;

}
