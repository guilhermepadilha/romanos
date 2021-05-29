package ConverteServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import br.com.guilherme.romano.domain.factory.DecimalFactory;
import br.com.guilherme.romano.domain.factory.RomanoFactory;
import br.com.guilherme.romano.domain.service.ConverterService;
import br.com.guilherme.romano.domain.service.dto.NumeroDecimalDto;
import br.com.guilherme.romano.domain.service.dto.NumeroRomanoDto;


public class ConverterServiceTest {

	private ConverterService service;
	
	public ConverterServiceTest() {
		this.service = new ConverterService(new RomanoFactory(), new DecimalFactory());		
	}
	
	
	@Test
	public void Conversao_de_1_a_2000_em_romano_Test() throws NumberFormatException, Exception {
		
		
		 Reader reader = Files.newBufferedReader(Paths.get("./resources/teste_romanos.csv"));
	     CSVReader csvReader = new CSVReaderBuilder(reader).build();
		
	     List<String[]> linhas = csvReader.readAll();
	     for (String[] linha : linhas) {
	    	 String[] valores = linha[0].split(";");
	    	
	    	NumeroRomanoDto numeroRomanoDto = service.converteParaRomano(Integer.parseInt(valores[0]));
	 		assertEquals(numeroRomanoDto.getNumeroRomano(),valores[1]);
	     }
	}
	
	@Test
	public void Conversao_de_1_a_2000_em_decimal_Test() throws Exception {
		
		
		 Reader reader = Files.newBufferedReader(Paths.get("./resources/teste_romanos.csv"));
	     CSVReader csvReader = new CSVReaderBuilder(reader).build();
		
	     List<String[]> linhas = csvReader.readAll();
	     for (String[] linha : linhas) {
	    	 String[] valores = linha[0].split(";");
	    	
	    	NumeroDecimalDto numeroDecimalDto = service.converteParaDecimal(valores[1]);
	 		assertEquals(numeroDecimalDto.getNumero().intValue(), Integer.parseInt(valores[0]));
	     }
	}
	
	@Test
	public void quando_eh_informado_decimal_invalido() {
	    Exception exception = assertThrows(RuntimeException.class, () -> {
	    	service.converteParaRomano(0);
	    });

	    String expectedMessage = "Valor inválido para conversão";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void quando_eh_informado_numeroRomano_invalido() {
	    Exception exception = assertThrows(RuntimeException.class, () -> {
	    	service.converteParaDecimal("XXU");
	    });

	    String expectedMessage = "Número Romano inválido. Permitido somente algarismos [ M, D, C, L, X, V, I ]";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

}
