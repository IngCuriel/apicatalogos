package com.curiel.catalogos.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curiel.catalogos.model.entity.FormaDePago;
import com.curiel.catalogos.model.entity.ReferenciaPago;

public interface ReferenciaPagoRepository extends JpaRepository<ReferenciaPago, Long>{
	
	@Query("SELECT u.id,u.decripcion,u.numeroCuenta FROM ReferenciaPago u WHERE u.formaDePago = ?1")
	List<Object[]> findByFormaDePago(FormaDePago formaPago);

}
