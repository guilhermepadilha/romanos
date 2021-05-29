package br.com.guilherme.romano.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guilherme.romano.domain.application.IConverterAppService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/converter")
public class ConverterController {

	private IConverterAppService converterAppService;
	
	@Autowired
	public ConverterController(IConverterAppService ConverterAppService) {
		this.converterAppService = ConverterAppService;
	}
	
	@GetMapping("pararomano/{numeroDecimal}")
	public ResponseEntity get(@PathVariable Integer numeroDecimal) throws Exception {
		try {
			return new ResponseEntity<>(converterAppService.converteParaRomano(numeroDecimal), HttpStatus.OK);			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("paradecimal/{numeroRomano}")
	public ResponseEntity get(@PathVariable String numeroRomano) {
		try {
			return new ResponseEntity<>(converterAppService.converteParaDecimal(numeroRomano.toUpperCase()), HttpStatus.OK);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());  
		}
	}
}
