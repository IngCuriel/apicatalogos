package com.curiel.catalogos.model.dto;

import java.math.BigDecimal;


import com.curiel.catalogos.model.entity.Producto;

import lombok.Data;

@Data
public class DetalleMovDto {
    Long id;
   
    BigDecimal cantidad;

    private ProductoDto producto;
    
    BigDecimal importe;

 }
