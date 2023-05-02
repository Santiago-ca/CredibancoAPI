package com.credibanco.assessment.card.dto;

public class CardConsultResponseDTO {
	private String pan;
	private String holderName;
	private String holderDni;
	private String holderPhone;
	private String state;
	
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
	public String getHolderPhone() {
		return holderPhone;
	}
	public void setHolderPhone(String holderPhone) {
		this.holderPhone = holderPhone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public CardConsultResponseDTO(String pan, String holderName, String holderDni, String holderPhone, String state) {
		super();
		this.pan = pan;
		this.holderName = holderName;
		this.holderDni = holderDni;
		this.holderPhone = holderPhone;
		this.state = state;
	}
	public CardConsultResponseDTO() {
		
	}
}
