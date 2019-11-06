package com.curiel.catalogos.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.curiel.catalogos.service.FileService;

@RestController
@RequestMapping("api/v1/files")
public class FileController {

     @Autowired
     private FileService fileService;
     
    @PostMapping("/cargar")
     public String cargarFile(@RequestParam("archivo") MultipartFile archivo) throws IOException {
         String nombreArvicvo=fileService.copiar(archivo);
         return nombreArvicvo;
     }
}
