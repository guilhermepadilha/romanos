package br.com.guilherme.romano.domain.exception;

import br.com.guilherme.romano.domain.model.AlgarismosRomanos;

public class InvalidValuesRomanException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -94510155987857627L;
	private static final String MESSAGE = "Número Romano inválido. Permitido somente algarismos [ M, D, C, L, X, V, I ]".concat(System.lineSeparator());
	
	public InvalidValuesRomanException() {
		super(MESSAGE);
	}
	
	public InvalidValuesRomanException(String description) {
		super(MESSAGE.concat(description));
	}

}
