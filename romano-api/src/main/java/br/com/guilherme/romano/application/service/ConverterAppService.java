package br.com.guilherme.romano.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.romano.domain.application.IConverterAppService;
import br.com.guilherme.romano.domain.service.ConverterService;
import br.com.guilherme.romano.domain.service.dto.NumeroDecimalDto;
import br.com.guilherme.romano.domain.service.dto.NumeroRomanoDto;

@Service
public class ConverterAppService implements IConverterAppService {

	private final ConverterService service;

	@Autowired
	public ConverterAppService(ConverterService service) {
		this.service = service;
	}
	
	@Override
	public NumeroRomanoDto converteParaRomano(Integer numeroDecimal) throws Exception {
			return this.service.converteParaRomano(numeroDecimal);
	}

	@Override
	public NumeroDecimalDto converteParaDecimal(String numeroRomano) throws Exception {
		return this.service.converteParaDecimal(numeroRomano);
	}

	

}
