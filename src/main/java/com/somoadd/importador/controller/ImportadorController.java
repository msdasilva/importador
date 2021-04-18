package com.somoadd.importador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.somoadd.importador.service.ImportadorService;

@RestController
public class ImportadorController {

	@Autowired
	private ImportadorService importadorService;
	
	@GetMapping(value = "/importadores/{caminho}")
	public ResponseEntity<String> loadImportador(@PathVariable(value = "caminho") String caminho) {
		
		try {			

			caminho = "C:\\Users\\add\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\importador";
			importadorService.loadImportador(caminho);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		
	}
}
