package br.com.guilherme.romano.domain.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class NumeroRomanoDto {
	private String numeroRomano;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Integer numeroDecimal;

	public String getNumeroRomano() {
		return numeroRomano;
	}
	
	public void setNumeroRomano(String numeroRomano) {
		this.numeroRomano = numeroRomano;
	}

	public Integer getNumeroDecimal() {
		return numeroDecimal;
	}

	public void setNumeroDecimal(int numeroDecimal) {
		this.numeroDecimal = numeroDecimal;
	}
}
