package com.curiel.catalogos.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.curiel.catalogos.model.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento,Long>{

    List<Movimiento> findByClienteProveedorOrderByIdDesc(String clienteProveedor);
    
    Page<Movimiento> findAllByOrderByIdDesc(Pageable pageable);
    
}
