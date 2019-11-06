package com.curiel.catalogos.repository;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curiel.catalogos.model.entity.UnidadMedida;

public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida,Long> {

    Set<UnidadMedida> findBySucursalId(Long sucursalId);
    
    @Query("update UnidadMedida set status.id=: statusId where id =: id")
    int updateStatusId(Long id,Long statusId);
}
