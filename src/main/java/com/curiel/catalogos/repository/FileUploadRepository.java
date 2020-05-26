package com.curiel.catalogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.curiel.catalogos.model.entity.FileUpload;

 
public interface FileUploadRepository extends JpaRepository<FileUpload, Long>  {

}
