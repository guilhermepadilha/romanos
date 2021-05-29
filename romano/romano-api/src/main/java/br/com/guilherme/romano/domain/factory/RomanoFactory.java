package br.com.guilherme.romano.domain.factory;




import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import br.com.guilherme.romano.domain.service.dto.NumeroDecimalDto;
import br.com.guilherme.romano.domain.service.dto.NumeroRomanoDto;

@Service
public class RomanoFactory {
	
	public NumeroRomanoDto converteParaRomano (Integer numeroDecimal) {
		
		NumeroRomanoDto numeroRomanoDto = new NumeroRomanoDto();
		NumeroDecimalDto numeroDecimalDto = new NumeroDecimalDto();
		numeroDecimalDto.setNumero(numeroDecimal);
		numeroDecimalDto = this.decomporNumero(numeroDecimalDto);
		
		
		  for (Integer parte : numeroDecimalDto.getNumeroDecomposto()) { 
			  if (parte > 3 &&  parte < 5) {
				  numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"IV")); 
		     }else if (parte <= 3){
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto, parte,"", "I")); 
		     }else if (parte == 5) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"V"));
		     }else if (parte > 8 && parte < 10) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"IX"));
		     }else if (parte <= 8) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto, parte,"V","I"));
		     } else if (parte == 10) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"X"));
		     }else if (parte > 30 && parte < 50) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"XL"));
		     }else if (parte <= 30){
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto, parte,"","X")); 
		     }else if (parte == 50) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"L"));
		     }else if (parte > 80 && parte < 100) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"XC"));
		     }else if (parte <= 80) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto, parte, "L", "X"));
		     } else if (parte == 100) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"C"));
		     }else if (parte > 300 &&  parte < 500) {
				  numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"CD")); 
		     }else if (parte <= 300){
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto, parte,"","C")); 
		     }else if (parte == 500) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"D"));
		     }else if (parte > 800 && parte < 1000) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto,"CM"));
		     }else if (parte <= 800) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto, parte,"D","C"));
		     } else if (parte >= 1000) {
		    	 numeroRomanoDto.setNumeroRomano(montaAlgarismo(numeroRomanoDto, parte,"","M"));
		     }
		  }
		 
		  return numeroRomanoDto;
	}
	
	private String montaAlgarismo(NumeroRomanoDto numeroRomanoDto, String algarismo) {
		
		String algarismoRomano = (numeroRomanoDto.getNumeroRomano() != null ? 
				numeroRomanoDto.getNumeroRomano() : "")
				.concat(algarismo);
		return algarismoRomano;
	}

	private String montaAlgarismo(NumeroRomanoDto numeroRomanoDto, Integer parte, String antecessorAlgarismo,String algarismo) {
		
		String algarismoRomano = antecessorAlgarismo;
		Integer quantidade = geraOrdem(parte) - (antecessorAlgarismo != "" ? 5 : 0 );
		for (int i = 0; i < quantidade; i++) {
			algarismoRomano = algarismoRomano.concat(algarismo);
		}
		numeroRomanoDto.setNumeroRomano((numeroRomanoDto.getNumeroRomano() != null ? numeroRomanoDto.getNumeroRomano() : "")
				.concat(algarismoRomano));
		
		return numeroRomanoDto.getNumeroRomano();
	}

	private NumeroDecimalDto decomporNumero(NumeroDecimalDto numeroDecimalDto) {
		
		String ordem = Integer.toString(geraOrdem(numeroDecimalDto.getNumero()));
		
		Integer parte = Integer.parseInt(StringUtils.rightPad(ordem, Integer.toString(numeroDecimalDto.getNumero()).length(),"0"));
		
		numeroDecimalDto.getNumeroDecomposto().add(parte);
		numeroDecimalDto.setNumero(numeroDecimalDto.getNumero() - parte);
		
		if(numeroDecimalDto.getNumero() > 0) {
			numeroDecimalDto = decomporNumero(numeroDecimalDto);
		}
		
		return numeroDecimalDto;
	}

	private Integer geraOrdem(Integer numeroDecimal) {
		String numero = Long.toString(numeroDecimal);
		return Integer.parseInt((numero.length() >= 4) ? numero.substring(0,numero.length() -3) : numero.substring(0,1));		
	} 
}
