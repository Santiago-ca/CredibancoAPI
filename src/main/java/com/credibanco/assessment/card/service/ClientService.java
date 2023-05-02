package com.credibanco.assessment.card.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.model.Client;

@Service
public interface ClientService extends CrudRepository<Client, Long> {
	public Client findByDni(String dni);
}
