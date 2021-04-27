 package com.curiel.catalogos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.curiel.catalogos.model.entity.Producto;
 
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	Page<Producto> findByStatus(int status,Pageable pageable);

	Page<Producto> findByStatusAndVisiblePage(int status,Boolean visiblePage,Pageable pageable);	
	
    Page<Producto> findBySucursalIdAndStatusAndVisiblePage(Long sucursalId,int status,Boolean visiblePage,Pageable pageable);

    Page<Producto> findBySucursalIdAndStatus(Long sucursalId,int status,Pageable pageable);
    
    Page<Producto> findByCategoriaIdAndStatusAndVisiblePage(Long categoriaId,int status,Boolean visiblePage,Pageable pageable);
    
    Page<Producto> findByCategoriaIdAndStatus(Long categoriaId,int status,Pageable pageable);
    
    Page<Producto> findByNombreContainingAndStatus(String nombre,int status,Pageable pageable);

    Page<Producto> findByNombreContainingAndStatusAndVisiblePage(String nombre,int status,Boolean visiblePage,Pageable pageable);
    
    Page<Producto> findByNombreContainingOrDescripcionContainingAndStatusAndVisiblePage(String nombre,String descripcion,int status,Boolean visiblePage,Pageable pageable); 
    
    Page<Producto> findByNombreContainingOrDescripcionContainingAndStatus(String nombre,String descripcion,int status,Pageable pageable);   
    
    Producto findByCodigoBarras(String codigoBarras);

}