package com.curiel.catalogos.repository;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import com.curiel.catalogos.model.entity.Producto;
 
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
    Set<Producto> findBySucursalIdAndStatus(Long sucursalId,int status);
    
    Set<Producto> findByNombreContainingAndStatus(String nombre,int status);

    Set<Producto> findByCategoriaIdAndStatus(Long categoriaId,int status);

}
