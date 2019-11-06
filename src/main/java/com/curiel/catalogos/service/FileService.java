package com.curiel.catalogos.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileService {
    private final Logger log = LoggerFactory.getLogger(FileService.class);

    private static final String  RUTA_ARCHIVO="files/";
    
    /*public String copiar(MultipartFile archivo) throws IOException {
        String nombreArchivo = UUID.randomUUID().toString() + "_" +archivo.getOriginalFilename().replace(" ", "");
        Path rutaArchivo = getPath(nombreArchivo);
        log.info(rutaArchivo.toString());
        Files.copy(archivo.getInputStream(), rutaArchivo);
        return nombreArchivo;
    }*/
    public Path getPath(String nombreFoto) {
        return Paths.get(RUTA_ARCHIVO).resolve(nombreFoto).toAbsolutePath();
    }
    
    public String copiar(MultipartFile archivo) throws IOException {
        String nombreArchivo = UUID.randomUUID().toString() + "." +archivo.getContentType().split("/")[1];
        Path path = Paths.get(RUTA_ARCHIVO+nombreArchivo);
        byte[] bytes=archivo.getBytes();
        Files.write(path, bytes);
        log.info(nombreArchivo);
        return nombreArchivo;
    }
}
