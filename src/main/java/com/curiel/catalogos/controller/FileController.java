package com.curiel.catalogos.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.UUID;

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

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
     
     @PostMapping("/excel")
     public ResponseEntity<String> loadExcel(@RequestParam("archivo") MultipartFile archivo) throws IOException {
    	 String fileName = UUID.randomUUID().toString() + "." +archivo.getContentType().split("/")[1];
    	 System.out.println(fileName);
         Path path = Paths.get("files/"+fileName);
         File f=path.toFile();
         System.out.println(path);
         
          String EXCEL_XLSX="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
         try {
             int i = 0;
             Workbook workbook = null; 
             if(EXCEL_XLSX.equals(archivo.getContentType())) 
             {
            	 workbook = new XSSFWorkbook(archivo.getInputStream());
             }else {
            	 workbook = new HSSFWorkbook(archivo.getInputStream());
              }
            
             
             //Creates a workbook object from the uploaded excelfile
                
             //Creates a worksheet object representing the first sheet
              Sheet worksheet = workbook.getSheetAt(0);
             //Reads the data in excel file until last row is encountered
             while (i < worksheet.getLastRowNum()) {
                 //Creates an object for the Candidate  Model
                 //Candidate candidate=new Candidate();
                 //Creates an object representing a single row in excel
                 Row row = worksheet.getRow(i++);
                 //Sets the Read data to the model class
                 System.out.println(row.getCell(1));
                // candidate.setCandidateId((int)row.getCell(0).getNumericCellValue());
                // candidate.setName(row.getCell(1).getStringCellValue());
                // candidate.setAddress(row.getCell(2).getStringCellValue());
                // candidate.setEmailId(row.getCell(3).getStringCellValue());
               //  candidate.setPinCode((int)row.getCell(4).getNumericCellValue());
               //.setAboutCandidate(row.getCell(5).getStringCellValue());
                 //Sends the model object to service layer for validation,
                 //data processing and then to persist
                // iCandidateService.saveCandidate(candidate);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
	         
         return new ResponseEntity<>(null,HttpStatus.OK);
     }
}
