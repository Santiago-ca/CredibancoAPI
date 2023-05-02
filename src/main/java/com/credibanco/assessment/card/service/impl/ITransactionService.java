package com.credibanco.assessment.card.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.model.Transaction;
import com.credibanco.assessment.card.service.TransactionService;

@Service
public class ITransactionService implements TransactionService{
	
	private final TransactionService TRANSACTION_SERVICE;
	
	@Autowired
	public ITransactionService (TransactionService transactionService) {
		this.TRANSACTION_SERVICE = transactionService;
	}
	
	@Override
	public <S extends Transaction> S save(S entity) {
		return TRANSACTION_SERVICE.save(entity);
	}

	@Override
	public <S extends Transaction> Iterable<S> saveAll(Iterable<S> entities) {
		return TRANSACTION_SERVICE.saveAll(entities);
	}

	@Override
	public Optional<Transaction> findById(Long id) {
		return TRANSACTION_SERVICE.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return TRANSACTION_SERVICE.existsById(id);
	}

	@Override
	public Iterable<Transaction> findAll() {
		return TRANSACTION_SERVICE.findAll();
	}

	@Override
	public Iterable<Transaction> findAllById(Iterable<Long> ids) {
		return TRANSACTION_SERVICE.findAllById(ids);
	}

	@Override
	public long count() {
		return TRANSACTION_SERVICE.count();
	}

	@Override
	public void deleteById(Long id) {
		TRANSACTION_SERVICE.deleteById(id);
	}

	@Override
	public void delete(Transaction entity) {
		TRANSACTION_SERVICE.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		TRANSACTION_SERVICE.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Transaction> entities) {
		TRANSACTION_SERVICE.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		TRANSACTION_SERVICE.deleteAll();
	}

	@Override
	public Transaction findByReferenceNumber(String refferenceNumber) {
		return TRANSACTION_SERVICE.findByReferenceNumber(refferenceNumber);
	}

}
