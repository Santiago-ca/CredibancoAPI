package com.credibanco.assessment.card.dto;

public class CardCreationRequestDTO {
	private String pan;
	private String holderName;
	private String holderDni;
	private String type;
	private String holderPhone;
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getHolderDni() {
		return holderDni;
	}
	public void setHolderDni(String holderDni) {
		this.holderDni = holderDni;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHolderPhone() {
		return holderPhone;
	}
	public void setHolderPhone(String holderPhone) {
		this.holderPhone = holderPhone;
	}
	public CardCreationRequestDTO(String pan, String holderName, String holderDni, String type, String holderPhone) {
		super();
		this.pan = pan;
		this.holderName = holderName;
		this.holderDni = holderDni;
		this.type = type;
		this.holderPhone = holderPhone;
	}
	public CardCreationRequestDTO() {
		
	}
}
