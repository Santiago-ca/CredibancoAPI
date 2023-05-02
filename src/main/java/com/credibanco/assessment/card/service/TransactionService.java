package com.credibanco.assessment.card.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.model.Transaction;

@Service
public interface TransactionService extends CrudRepository<Transaction, Long>{
	public Transaction findByReferenceNumber(String refferenceNumber);
}
