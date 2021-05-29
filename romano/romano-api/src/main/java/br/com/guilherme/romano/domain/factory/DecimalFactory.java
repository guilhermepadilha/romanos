package br.com.guilherme.romano.domain.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.guilherme.romano.domain.model.AlgarismosRomanos;
import br.com.guilherme.romano.domain.service.dto.NumeroDecimalDto;

@Service
public class DecimalFactory {
	
	private final Map<String, Integer> algarismosMap = new HashMap<>();
	public DecimalFactory() {
		for (AlgarismosRomanos algarismo : AlgarismosRomanos.values()) {
			algarismosMap.put(algarismo.name(), algarismo.valorAlgarismo);
		}
	}
	
	public NumeroDecimalDto converterParaDecimal(String numeroRomano) {
		
		NumeroDecimalDto numeroDecimalDto = decomporRomano(numeroRomano);
		
		if (numeroDecimalDto.getNumero() == null)
			numeroDecimalDto.setNumero(0);
		
		for (int i = 0; i < numeroDecimalDto.getNumeroDecomposto().size(); i++) {
			
			if (verificaSomatorio(numeroDecimalDto, i)) {
				numeroDecimalDto.setNumero(numeroDecimalDto.getNumero() + numeroDecimalDto.getNumeroDecomposto().get(i));
			}else {
				numeroDecimalDto.setNumero(numeroDecimalDto.getNumero() - numeroDecimalDto.getNumeroDecomposto().get(i));
			}
		}
		
		return numeroDecimalDto;
	}

	private boolean verificaSomatorio(NumeroDecimalDto numeroDecimalDto, Integer index) {
		Integer tamanhoLista = numeroDecimalDto.getNumeroDecomposto().size();
		return numeroDecimalDto
				.getNumeroDecomposto()
				.get(index) >= (tamanhoLista < index + 2 ? 0 :	numeroDecimalDto.getNumeroDecomposto().get(index +1));
	}
	
	private NumeroDecimalDto decomporRomano (String numeroRomano) {
		NumeroDecimalDto numeroDecimalDto = new NumeroDecimalDto();
		
		char[] arrayAlgarismos = numeroRomano.toCharArray();
		for(char algarismo : arrayAlgarismos){
           numeroDecimalDto.getNumeroDecomposto().add(algarismosMap.get(Character.toString(algarismo)));
		}
		
		return numeroDecimalDto;
	}

}
