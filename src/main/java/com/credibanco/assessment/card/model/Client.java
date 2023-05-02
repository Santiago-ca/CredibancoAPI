package com.credibanco.assessment.card.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String dni;
	private String name;
	private String phone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Client( String dni, String name, String phone) {
		super();
		this.dni = dni;
		this.name = name;
		this.phone = phone;
	}
	public Client() {
		
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", dni=" + dni + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
