package com.credibanco.assessment.card.dto;

public class CardEnrollRequestDTO {
	private String pan;
	private int validationNumber;
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public int getValidationNumber() {
		return validationNumber;
	}
	public void setValidationNumber(int validationNumber) {
		this.validationNumber = validationNumber;
	}
	public CardEnrollRequestDTO(String pan, int validationNumber) {
		super();
		this.pan = pan;
		this.validationNumber = validationNumber;
	}
	public CardEnrollRequestDTO() {
		
	}
}
