package com.credibanco.assessment.card.dto;

public class TransactionCancelRequestDTO {
	private String cardPan;
	private String referenceNumber;
	private double totalValue;
	public String getCardPan() {
		return cardPan;
	}
	public void setCardPan(String cardPan) {
		this.cardPan = cardPan;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public TransactionCancelRequestDTO(String cardPan, String referenceNumber, double totalValue) {
		super();
		this.cardPan = cardPan;
		this.referenceNumber = referenceNumber;
		this.totalValue = totalValue;
	}
	public TransactionCancelRequestDTO() {
		
	}
}
