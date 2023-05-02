package com.credibanco.assessment.card.dto;

public class CardDeleteResponseDTO {
	private String responseCode;
	private String message;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CardDeleteResponseDTO(String responseCode, String message) {
		super();
		this.responseCode = responseCode;
		this.message = message;
	}
	public CardDeleteResponseDTO() {
		
	}
}
