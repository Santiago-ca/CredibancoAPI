package com.credibanco.assessment.card.dto;

public class TransactionCreationRequestDTO {
	private String cardPan;
	private String referenceNumber;
	private double totalValue;
	private String commerceAddress;
	
	public String getCardPan() {
		return cardPan;
	}
	public void setCardPan(String cardPan) {
		this.cardPan = cardPan;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String refferenceNumber) {
		this.referenceNumber = refferenceNumber;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public String getCommerceAddress() {
		return commerceAddress;
	}
	public void setCommerceAddress(String commerceAddress) {
		this.commerceAddress = commerceAddress;
	}
	public TransactionCreationRequestDTO(String cardPan, String refferenceNumber, double totalValue,
			String commerceAddress) {
		super();
		this.cardPan = cardPan;
		this.referenceNumber = refferenceNumber;
		this.totalValue = totalValue;
		this.commerceAddress = commerceAddress;
	}
	public TransactionCreationRequestDTO() {
		
	}
}
