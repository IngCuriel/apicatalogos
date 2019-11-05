package com.curiel.catalogos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.curiel.catalogos.model.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento,Long>{

    Movimiento findByClienteProveedor(String clienteProveedor);
}
