package com.curiel.catalogos.repository;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curiel.catalogos.model.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento,Long>{

    List<Movimiento> findByClienteProveedor(String clienteProveedor);
    
    
}
