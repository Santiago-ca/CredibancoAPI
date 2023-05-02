package com.credibanco.assessment.card.dto;

public class TransactionCancelResponseDTO {
	private String responseCode;
	private String message;
	private String referenceNumber;
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
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public TransactionCancelResponseDTO(String responseCode, String message, String referenceNumber) {
		super();
		this.responseCode = responseCode;
		this.message = message;
		this.referenceNumber = referenceNumber;
	}
	public TransactionCancelResponseDTO() {
		
	}
}
