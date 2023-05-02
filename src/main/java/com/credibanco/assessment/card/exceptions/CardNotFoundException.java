package com.credibanco.assessment.card.exceptions;

public class CardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4736047620145018214L;

	public CardNotFoundException(String message) {
		super(message);
	}
}