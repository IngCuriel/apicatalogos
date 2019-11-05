package com.curiel.catalogos.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curiel.catalogos.model.entity.UnidadMedida;

public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida,Long> {

    Set<UnidadMedida> findBySucursalId(Long id);
}
