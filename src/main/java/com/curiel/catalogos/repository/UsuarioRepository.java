package com.curiel.catalogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curiel.catalogos.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
	Usuario findByEmail(String email);
}
