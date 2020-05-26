package com.curiel.catalogos.controller;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curiel.catalogos.model.entity.FileUpload;
import com.curiel.catalogos.service.FileService;
import com.curiel.catalogos.service.FileUploadService;
 
@RestController
@RequestMapping("api/v1/fileupload")
public class FileUploadController {

	// private final StorageService storageService;

	@Autowired
	private FileService fileService;

	@Autowired
	private FileUploadService fileUploadService;

	/**
	 * @Autowired public FileUploadController(StorageService storageService) {
	 *            this.storageService = storageService; }
	 * 
	 *            @GetMapping("/") public String listUploadedFiles(Model model)
	 *            throws IOException {
	 * 
	 *            model.addAttribute("files", storageService.loadAll().map( path ->
	 *            MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
	 *            "serveFile",
	 *            path.getFileName().toString()).build().toUri().toString())
	 *            .collect(Collectors.toList()));
	 * 
	 *            return "uploadForm"; }
	 * 
	 *            @GetMapping("/files/{filename:.+}")
	 * @ResponseBody public ResponseEntity<Resource> serveFile(@PathVariable String
	 *               filename) {
	 * 
	 *               Resource file = storageService.loadAsResource(filename); return
	 *               ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
	 *               "attachment; filename=\"" + file.getFilename() +
	 *               "\"").body(file); }
	 **/
	@PostMapping("/{nombre}")
	public ResponseEntity<String> handleFileUpload(@PathVariable("nombre") String nombre,
			@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		 fileUploadService.save(nombre, file);
		System.out.println(redirectAttributes);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");
		return new ResponseEntity<>("cargado", HttpStatus.OK);
	}
    
	@GetMapping("/")
	public ResponseEntity<Set<FileUpload>> getLisArchivo(){
		return new ResponseEntity<>(fileUploadService.getList(),HttpStatus.OK);
	}
	/**
	 * @ExceptionHandler(StorageFileNotFoundException.class) public
	 *                                                       ResponseEntity<?>
	 *                                                       handleStorageFileNotFound(StorageFileNotFoundException
	 *                                                       exc) { return
	 *                                                       ResponseEntity.notFound().build();
	 *                                                       }
	 **/

}
