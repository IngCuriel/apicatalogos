package com.curiel.catalogos.repository;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import com.curiel.catalogos.model.entity.Categoria;

public interface CategoriaRespository extends JpaRepository<Categoria, Long> {
	Set<Categoria> findByStatus(int status);
	
}
