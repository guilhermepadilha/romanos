package br.com.guilherme.romano.domain.application;

import org.springframework.web.bind.annotation.PathVariable;

import br.com.guilherme.romano.domain.service.dto.NumeroDecimalDto;
import br.com.guilherme.romano.domain.service.dto.NumeroRomanoDto;

public interface IConverterAppService {
	NumeroRomanoDto converteParaRomano(@PathVariable Integer numeroDecimal) throws Exception;

	NumeroDecimalDto converteParaDecimal(String numeroRomano) throws Exception;
}
