package com.curiel.catalogos.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curiel.catalogos.model.entity.ReferenciaPago;

public interface ReferenciaPagoRepository extends JpaRepository<ReferenciaPago, Long>{
	
	Set<ReferenciaPago> findByFormaDePagoId(Long id);

}
