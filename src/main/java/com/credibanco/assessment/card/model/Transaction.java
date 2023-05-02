package com.credibanco.assessment.card.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Card card;
	
	private String referenceNumber;
	private double totalValue;
	private Timestamp time;
	private String commerceAddress;
	private String state;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getCommerceAddress() {
		return commerceAddress;
	}
	public void setCommerceAddress(String commerceAddress) {
		this.commerceAddress = commerceAddress;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Transaction(Card card, String referenceNumber, double totalValue, Timestamp time, String commerceAddress, String state) {
		super();
		this.card = card;
		this.referenceNumber = referenceNumber;
		this.totalValue = totalValue;
		this.time = time;
		this.commerceAddress = commerceAddress;
		this.state = state;
	}
	public Transaction() {
		
	}
}
