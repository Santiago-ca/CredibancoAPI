package com.credibanco.assessment.card.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.model.Card;

@Service
public interface CardService extends CrudRepository<Card, Long>{
	public Card findByPan(String pan);
}
