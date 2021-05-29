package br.com.guilherme.romano.domain.service.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class NumeroDecimalDto {
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Integer> numeroDecomposto = new ArrayList<Integer>();
	
	private Integer numero;

	public List<Integer> getNumeroDecomposto() {
		return numeroDecomposto;
	}

	public void setNumeroDecomposto(List<Integer> numeroDecomposto) {
		this.numeroDecomposto = numeroDecomposto;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
