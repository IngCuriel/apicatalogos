package com.curiel.catalogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curiel.catalogos.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
