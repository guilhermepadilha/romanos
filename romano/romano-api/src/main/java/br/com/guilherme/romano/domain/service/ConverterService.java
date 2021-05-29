package br.com.guilherme.romano.domain.service;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guilherme.romano.domain.factory.RomanoFactory;
import br.com.guilherme.romano.domain.model.AlgarismosRomanos;
import br.com.guilherme.romano.domain.exception.InvalidValueDecimalException;
import br.com.guilherme.romano.domain.exception.InvalidValuesRomanException;
import br.com.guilherme.romano.domain.factory.DecimalFactory;
import br.com.guilherme.romano.domain.service.dto.NumeroDecimalDto;
import br.com.guilherme.romano.domain.service.dto.NumeroRomanoDto;

@Service
public class ConverterService {
	
	
	private final RomanoFactory romanoFactory;
	private final DecimalFactory decimalFactory;
	
	@Autowired
	public ConverterService(RomanoFactory RomanoFactory, DecimalFactory DecimalFactory) {
		this.romanoFactory = RomanoFactory;
		this.decimalFactory = DecimalFactory;
	}
	
	public NumeroRomanoDto converteParaRomano(Integer numeroDecimal) throws Exception {
		if (numeroDecimal > 0) {
			return this.romanoFactory.converteParaRomano(numeroDecimal);
		}
		
		throw new InvalidValueDecimalException();
	}
	
	public NumeroDecimalDto converteParaDecimal(String numeroRomano) throws Exception {
		if (validaNumeroRomano(numeroRomano))
			return this.decimalFactory.converterParaDecimal(numeroRomano);
		
		throw new InvalidValuesRomanException();
	}
	
	private boolean validaNumeroRomano (String numeroRomano) {
		for (char caracter : numeroRomano.toCharArray()) {
			if(AlgarismosRomanos.asAlgarismoRomano(Character.toString(caracter)) == null) {
				return false;
			}
		}
		return true;
	}
}
