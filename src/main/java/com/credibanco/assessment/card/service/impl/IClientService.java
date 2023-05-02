package com.credibanco.assessment.card.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.model.Client;
import com.credibanco.assessment.card.service.ClientService;

@Service
public class IClientService implements ClientService{
	
	private final ClientService CLIENT_SERVICE;
	
	@Autowired
	public IClientService(ClientService clientService) {
		this.CLIENT_SERVICE = clientService;
	}
	
	@Override
	public <S extends Client> S save(S entity) {
		return CLIENT_SERVICE.save(entity);
	}

	@Override
	public <S extends Client> Iterable<S> saveAll(Iterable<S> entities) {
		return CLIENT_SERVICE.saveAll(entities);
	}

	@Override
	public Optional<Client> findById(Long id) {
		return CLIENT_SERVICE.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return CLIENT_SERVICE.existsById(id);
	}

	@Override
	public Iterable<Client> findAll() {
		return CLIENT_SERVICE.findAll();
	}

	@Override
	public Iterable<Client> findAllById(Iterable<Long> ids) {
		return CLIENT_SERVICE.findAllById(ids);
	}

	@Override
	public long count() {
		return CLIENT_SERVICE.count();
	}

	@Override
	public void deleteById(Long id) {
		CLIENT_SERVICE.deleteById(id);
	}

	@Override
	public void delete(Client entity) {
		CLIENT_SERVICE.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		CLIENT_SERVICE.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Client> entities) {
		CLIENT_SERVICE.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		CLIENT_SERVICE.deleteAll();
	}

	@Override
	public Client findByDni(String dni) {
		return CLIENT_SERVICE.findByDni(dni);
	}

}
