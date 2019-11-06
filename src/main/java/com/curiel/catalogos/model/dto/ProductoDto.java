package com.curiel.catalogos.model.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
     
    Long id;
    String nombre;
    String decripcion;
    BigDecimal precio;
    BigDecimal costo;
    
}
