package com.credibanco.assessment.card.dto;

public class CardCreationResponseDTO {
	private String responseCode;
	private String messageCode;
	private int validationNumber;
	private String pan;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public int getValidationNumber() {
		return validationNumber;
	}
	public void setValidationNumber(int validationNumber) {
		this.validationNumber = validationNumber;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public CardCreationResponseDTO(String responseCode, String messageCode, int validationNumber, String pan) {
		super();
		this.responseCode = responseCode;
		this.messageCode = messageCode;
		this.validationNumber = validationNumber;
		this.pan = pan;
	}
	public CardCreationResponseDTO() {
		
	}
	
}
