package com.curiel.catalogos.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.curiel.catalogos.model.entity.Sucursal;
import com.curiel.catalogos.repository.SucursalRepository;
import com.curiel.catalogos.service.FileService;

@RestController
@RequestMapping("api/v1/files")
public class FileController {

    @Autowired
    private FileService fileService;
    
    @Autowired
    private SucursalRepository sucursalRepository;
     
    @PostMapping("/logos/sucursales")
     public ResponseEntity<String> cargarFile(@RequestParam Long sucursalId,@RequestParam("archivo") MultipartFile archivo,UriComponentsBuilder uriComponentsBuilder) throws IOException {
        Sucursal sucursal = sucursalRepository.getOne(sucursalId);
        if(!sucursal.getLogo().isEmpty() || sucursal.getLogo()!=null) {
            fileService.deleteFile(sucursal.getLogo());
        }
        String nombreArchivo=fileService.copiar(archivo);
        sucursal.setLogo(nombreArchivo);
        sucursalRepository.save(sucursal);
        return new ResponseEntity<>(nombreArchivo,HttpStatus.OK);
     }
     
     @GetMapping("/imagenes/productos")
     public ResponseEntity<byte[]> getFile(@RequestParam Long productoId){
        Sucursal sucursal = sucursalRepository.getOne(productoId);
        if(sucursal.getLogo().isEmpty() || sucursal.getLogo()==null) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
         }
        sucursal.getLogo();
        return null;
     }
}
