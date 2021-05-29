package br.com.guilherme.romano.domain.exception;

public class InvalidValueDecimalException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -94510155987857627L;
	private static final String MESSAGE = "Valor inválido para conversão".concat(System.lineSeparator());
	
	public InvalidValueDecimalException() {
		super(MESSAGE);
	}
	
	public InvalidValueDecimalException(String description) {
		super(MESSAGE.concat(description));
	}

}
