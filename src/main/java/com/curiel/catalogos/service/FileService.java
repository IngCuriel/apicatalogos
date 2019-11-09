package com.curiel.catalogos.service;

import java.io.File;
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
    
    public String copiar(MultipartFile archivo) throws IOException {
        String fileName = UUID.randomUUID().toString() + "." +archivo.getContentType().split("/")[1];
        Path path = Paths.get(RUTA_ARCHIVO+fileName);
        byte[] bytes=archivo.getBytes();
        Files.write(path, bytes);
        log.info(fileName);
        return fileName;
    }
    
    public String deleteFile(String fileName) {
        log.info("Delete File --->");
        String Respuesta="No exite";
        Path path=Paths.get(RUTA_ARCHIVO+fileName);
        File f=path.toFile();
        if(f.exists()) {
            Respuesta=(f.delete()) ? "Existe Eliminado":"Existe no eliminado";
        }
        return Respuesta;
    }
    
    public byte[] getFile() {
        return null;
    }
}
