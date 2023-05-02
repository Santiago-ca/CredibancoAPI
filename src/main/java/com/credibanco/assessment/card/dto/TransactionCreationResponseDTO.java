package com.credibanco.assessment.card.dto;

public class TransactionCreationResponseDTO {
	private String responseCode;
	private String message;
	private String transactionState;
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
	public String getTransactionState() {
		return transactionState;
	}
	public void setTransactionState(String transactionState) {
		this.transactionState = transactionState;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public TransactionCreationResponseDTO(String responseCode, String message, String transactionState,
			String referenceNumber) {
		super();
		this.responseCode = responseCode;
		this.message = message;
		this.transactionState = transactionState;
		this.referenceNumber = referenceNumber;
	}
	public TransactionCreationResponseDTO() {
		
	}
}
