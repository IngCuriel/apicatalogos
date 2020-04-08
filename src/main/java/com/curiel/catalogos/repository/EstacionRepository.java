package com.curiel.catalogos.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.curiel.catalogos.model.entity.Estacion;

public interface EstacionRepository  extends JpaRepository<Estacion, Long>{
     
}
