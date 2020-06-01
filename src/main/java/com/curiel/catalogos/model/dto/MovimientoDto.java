package com.curiel.catalogos.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.curiel.catalogos.emun.StatusMovimiento;
import com.curiel.catalogos.model.entity.MovimientoFormaPago;

import lombok.Data;

@Data
public class MovimientoDto {
 
    Long id;

    String descripcion;

    String observacion;

    String clienteProveedor;
    
    private String system;
    
    private StatusMovimiento status; 
    
    private Set<DetalleMovDto> detallesMov;
    
    private Set<MovimientoFormaPagoDto> movimientoFormaPago;
    
    BigDecimal total;
    
    private Date dateCreated;
    
    private Date dateUpdated;
     
  
   /* public BigDecimal getTotal() {
         BigDecimal total = BigDecimal.ZERO;
          for(DetalleMovDto detall:detallesMov) {
              total =total.add(detall.getImporte());
         }
        return total;
     }*/
}
