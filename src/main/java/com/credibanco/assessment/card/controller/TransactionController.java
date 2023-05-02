package com.credibanco.assessment.card.controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.dto.TransactionCancelRequestDTO;
import com.credibanco.assessment.card.dto.TransactionCancelResponseDTO;
import com.credibanco.assessment.card.dto.TransactionCreationRequestDTO;
import com.credibanco.assessment.card.dto.TransactionCreationResponseDTO;
import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.model.Transaction;
import com.credibanco.assessment.card.service.impl.ICardService;
import com.credibanco.assessment.card.service.impl.IClientService;
import com.credibanco.assessment.card.service.impl.ITransactionService;

@RestController
@RequestMapping("api/")
public class TransactionController {

	@Autowired
	ICardService cardService;

	@Autowired
	IClientService clientService;
	
	@Autowired
	ITransactionService transactionService;

	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping(value="transaction/create")
	@ResponseBody
	public TransactionCreationResponseDTO createTransaction(@RequestBody TransactionCreationRequestDTO creationRequest) {
		TransactionCreationResponseDTO creationResponse = new TransactionCreationResponseDTO();
		Card currentCard = cardService.findByPan(creationRequest.getCardPan());
		Transaction newTransaction = new Transaction();
		if(currentCard!=null){
			newTransaction.setCard(currentCard);
			newTransaction.setReferenceNumber(creationRequest.getReferenceNumber());
			newTransaction.setTotalValue(creationRequest.getTotalValue());
			newTransaction.setTime(new Timestamp(System.currentTimeMillis()));
			newTransaction.setCommerceAddress(creationRequest.getCommerceAddress());
			if(currentCard.getState().equals("Enrolada")) {
				newTransaction.setState("Apobada");
				transactionService.save(newTransaction);
				
				creationResponse.setResponseCode("00");
				creationResponse.setMessage("Compra exitosa");
				creationResponse.setReferenceNumber(newTransaction.getReferenceNumber());
				creationResponse.setTransactionState(newTransaction.getState());
			}else {
				newTransaction.setState("Rechazada");
				transactionService.save(newTransaction);
				
				creationResponse.setResponseCode("02");
				creationResponse.setMessage("Tarjeta no enrolada");
				creationResponse.setReferenceNumber(newTransaction.getReferenceNumber());
				creationResponse.setTransactionState(newTransaction.getState());
			}
		}else {
			creationResponse.setResponseCode("01");
			creationResponse.setMessage("Tarjeta no existe");
			creationResponse.setReferenceNumber(creationRequest.getReferenceNumber());
			creationResponse.setTransactionState("Rechazada");
		}
		
		return creationResponse;
	}
	
	@PostMapping(value="transaction/cancel")
	@ResponseBody
	public TransactionCancelResponseDTO cancelTransaction(@RequestBody TransactionCancelRequestDTO cancelRequest) {
		TransactionCancelResponseDTO cancelResponse = new TransactionCancelResponseDTO();
		cancelResponse.setReferenceNumber(cancelRequest.getReferenceNumber());
		Transaction currentTransaction = transactionService.findByReferenceNumber(cancelRequest.getReferenceNumber());
		if(currentTransaction!=null) {
			if(isTransactionOnTime(currentTransaction.getTime())) {
				currentTransaction.setState("Anulada");
				transactionService.save(currentTransaction);
				
				cancelResponse.setResponseCode("00");
				cancelResponse.setMessage("Compra anulada");
			}else {
				cancelResponse.setResponseCode("02");
				cancelResponse.setMessage("No se puede anular la transaccion");
			}
		}else {
			cancelResponse.setResponseCode("01");
			cancelResponse.setMessage("Numero de referencia invalido");
		}
		return cancelResponse;
	}
	
	private boolean isTransactionOnTime(Timestamp transactionTime) {
		Date transactionDate = new Date(transactionTime.getTime());
		Date currentDate = new Date(new Timestamp(System.currentTimeMillis()).getTime());
		
		long differenceInMillies = Math.abs(currentDate.getTime() - transactionDate.getTime());
	    long totalMinutes = TimeUnit.MINUTES.convert(differenceInMillies, TimeUnit.MILLISECONDS);
		
		return totalMinutes<5;
	}
	
}
