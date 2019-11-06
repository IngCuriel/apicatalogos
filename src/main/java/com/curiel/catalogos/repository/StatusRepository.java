package com.curiel.catalogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curiel.catalogos.model.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{

}
