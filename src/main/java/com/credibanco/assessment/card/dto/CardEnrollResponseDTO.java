package com.credibanco.assessment.card.dto;

public class CardEnrollResponseDTO {
	private String responseCode;
	private String message;
	private String pan;
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
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public CardEnrollResponseDTO(String responseCode, String message, String pan) {
		super();
		this.responseCode = responseCode;
		this.message = message;
		this.pan = pan;
	}
	public CardEnrollResponseDTO() {
		
	}
}
