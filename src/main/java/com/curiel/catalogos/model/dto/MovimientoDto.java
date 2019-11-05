package com.curiel.catalogos.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import lombok.Data;

@Data
public class MovimientoDto {
 
    Long id;

    String descripcion;

    String observacion;

    String clienteProveedor;
  
    private Set<DetalleMovDto> detallesMov;
    
    private Date createAt;
  
    public BigDecimal getTotal() {
         BigDecimal total = BigDecimal.ZERO;
          for(DetalleMovDto detall:detallesMov) {
              total =total.add(detall.getImporte());
         }
        return total;
     }
}
