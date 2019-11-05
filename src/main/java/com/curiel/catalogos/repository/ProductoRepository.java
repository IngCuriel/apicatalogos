package com.curiel.catalogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curiel.catalogos.model.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
