package com.curiel.catalogos.model.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDto {
    
    Long id;
    String nombre;
    String descripcion;
    Set<ProductoDto> productos;
    
}
