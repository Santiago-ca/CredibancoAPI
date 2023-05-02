package com.credibanco.assessment.card.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.service.CardService;

@Service
public class ICardService implements CardService {

	private final CardService cardService;

	@Autowired
	public ICardService(CardService cardService) {
		this.cardService = cardService;
	}

	@Override
	public <S extends Card> S save(S entity) {
		return cardService.save(entity);
	}

	@Override
	public <S extends Card> Iterable<S> saveAll(Iterable<S> entities) {
		return cardService.saveAll(entities);
	}

	@Override
	public Optional<Card> findById(Long id) {
		return cardService.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return cardService.existsById(id);
	}

	@Override
	public Iterable<Card> findAll() {
		return cardService.findAll();
	}

	@Override
	public Iterable<Card> findAllById(Iterable<Long> ids) {
		return cardService.findAllById(ids);
	}

	@Override
	public long count() {
		return cardService.count();
	}

	@Override
	public void deleteById(Long id) {
		cardService.deleteById(id);
	}

	@Override
	public void delete(Card entity) {
		cardService.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		cardService.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Card> entities) {
		cardService.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cardService.deleteAll();
	}

	@Override
	public Card findByPan(String pan) {
		return cardService.findByPan(pan);
	}

}
