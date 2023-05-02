package com.credibanco.assessment.card.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String pan;
	@ManyToOne
	private Client holder;
	private String state;
	private int validationNumber;
	private String type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Client getHolder() {
		return holder;
	}
	public void setHolder(Client holder) {
		this.holder = holder;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getValidationNumber() {
		return validationNumber;
	}
	public void setValidationNumber(int validationNumber) {
		this.validationNumber = validationNumber;
	}
	public Card(String pan, Client holder, String state, int validationNumber, String type) {
		super();
		this.pan = pan;
		this.holder = holder;
		this.state = state;
		this.validationNumber = validationNumber;
		this.type = type;
	}
	public Card() {
		
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", pan=" + pan + ", holder=" + holder + ", state=" + state + ", type=" + type + "]";
	}
	
}
