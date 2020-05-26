package com.curiel.catalogos.service;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.curiel.catalogos.model.entity.FileUpload;
import com.curiel.catalogos.repository.FileUploadRepository;

@Service
public class FileUploadService {
	
  @Autowired
  private FileUploadRepository fileUploadRepository;
  @Autowired
  private FileService fileService;
  
  @Transactional
  public FileUpload save(String name, MultipartFile archivo) {
	  FileUpload entity=new FileUpload();
	  try {
		  entity.setNombreReal(name);
    	  String nombreCreado=fileService.copiar(archivo);
    	  String StringByte=fileService.getStringByte(nombreCreado);
    	  entity.setData(StringByte);
    	  entity.setNombreCreado(nombreCreado);
    	  fileUploadRepository.save(entity);
	} catch (IOException e) {
		e.printStackTrace();
	}  	     
	  return entity;
  }
  
  public Set<FileUpload> getList(){
	  Set<FileUpload>  listFile= new LinkedHashSet<>();
	  fileUploadRepository.findAll().forEach(file->{
		  listFile.add(file);
	  });
 	   return listFile;
  }
	
}
