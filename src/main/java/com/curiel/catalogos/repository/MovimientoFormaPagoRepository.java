package com.curiel.catalogos.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curiel.catalogos.model.entity.Movimiento;
import com.curiel.catalogos.model.entity.MovimientoFormaPago;

public interface MovimientoFormaPagoRepository extends JpaRepository<MovimientoFormaPago,Long>{

	List<MovimientoFormaPago> findByMovimiento(Movimiento movimiento);
	
}
