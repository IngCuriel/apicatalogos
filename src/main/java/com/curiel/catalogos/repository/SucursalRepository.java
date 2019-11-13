package com.curiel.catalogos.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.curiel.catalogos.model.entity.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long>{

	@Modifying
	@Query("update Sucursal set status=:status where id=:id")
	int updateStatus(Long id,int status);
	 
	@Modifying
	@Query( value="update sucursal set me_gusta = me_gusta+?2 where id = ?1",nativeQuery = true)
	int updateByIdAndMeGusta(Long id,int masUno);
	
	
	Set<Sucursal> findByStatus(int status);
}
