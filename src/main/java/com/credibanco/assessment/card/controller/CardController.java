package com.credibanco.assessment.card.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.card.dto.CardConsultResponseDTO;
import com.credibanco.assessment.card.dto.CardCreationRequestDTO;
import com.credibanco.assessment.card.dto.CardCreationResponseDTO;
import com.credibanco.assessment.card.dto.CardDeleteRequestDTO;
import com.credibanco.assessment.card.dto.CardDeleteResponseDTO;
import com.credibanco.assessment.card.dto.CardEnrollRequestDTO;
import com.credibanco.assessment.card.dto.CardEnrollResponseDTO;
import com.credibanco.assessment.card.exceptions.CardNotFoundException;
import com.credibanco.assessment.card.model.Card;
import com.credibanco.assessment.card.model.Client;
import com.credibanco.assessment.card.service.impl.ICardService;
import com.credibanco.assessment.card.service.impl.IClientService;

@RestController
@RequestMapping("api/card")
public class CardController {

	@Autowired
	ICardService cardService;

	@Autowired
	IClientService clientService;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(value = "/cards")
	@ResponseBody
	public List<Card> getCards() {
		List<Card> allCards = new ArrayList<Card>();
		allCards.addAll((List<Card>) cardService.findAll());
		System.out.println("Total:"+ allCards.size());
		return (List<Card>) cardService.findAll();
	}

	@PostMapping(value = "/create")
	@ResponseBody
	public CardCreationResponseDTO createCard(@RequestBody CardCreationRequestDTO creationRequest) {
		CardCreationResponseDTO creationResponse = new CardCreationResponseDTO();
		try {
			Client client = clientService.findByDni(creationRequest.getHolderDni());
			if(client ==null) {
				//clientService.save(modelMapper.map(creationRequest, Client.class));
				client = new Client(creationRequest.getHolderDni(), creationRequest.getHolderName(), creationRequest.getHolderPhone());
				clientService.save(client);
			}else {
				client.setPhone(creationRequest.getHolderPhone());
				clientService.save(client);
			}
			
			Card newCard = new Card(creationRequest.getPan(), client, "Creada", generateValidationNumber(),creationRequest.getType());
			cardService.save(newCard);

			creationResponse.setPan(this.maskPAN(newCard.getPan()));
			creationResponse.setResponseCode("00");
			creationResponse.setMessageCode("Exito");
			creationResponse.setValidationNumber(newCard.getValidationNumber());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			creationResponse.setResponseCode("01");
			creationResponse.setMessageCode("Fallido");
		}
		return creationResponse;

	}

	@PostMapping(value="/enroll")
	@ResponseBody
	public CardEnrollResponseDTO enrollCard(@RequestBody CardEnrollRequestDTO enrollRequest) {
		CardEnrollResponseDTO enrollResponse = new CardEnrollResponseDTO();

		Card card = cardService.findByPan(enrollRequest.getPan());
		if(card!=null) {
			if(card.getValidationNumber()==enrollRequest.getValidationNumber()) {
				card.setState("Enrolada");
				cardService.save(card);
				
				enrollResponse.setResponseCode("00");
				enrollResponse.setMessage("Exito");
				enrollResponse.setPan(this.maskPAN(card.getPan()));
			}else {
				enrollResponse.setResponseCode("02");
				enrollResponse.setMessage("Numero de validacion invalido");
			}
		}else {
			enrollResponse.setResponseCode("01");
			enrollResponse.setMessage("Tarjeta no existe");
		}

		return enrollResponse;
	}
	
	@GetMapping(value = "")
	@ResponseBody
	public CardConsultResponseDTO getCard(@RequestParam(required = true) String pan) {
		CardConsultResponseDTO consultResponse = new CardConsultResponseDTO();
		Card consultedCard = cardService.findByPan(pan);
		if(consultedCard!=null) {
			consultResponse = modelMapper.map(consultedCard, CardConsultResponseDTO.class);
		}else {
			throw new CardNotFoundException("Card not found");
		}
		return consultResponse;
	}
	
	@DeleteMapping(value = "/delete")
	@ResponseBody
	public CardDeleteResponseDTO deleteCard(@RequestBody CardDeleteRequestDTO deleteRequest) {
		CardDeleteResponseDTO deleteResponse = new CardDeleteResponseDTO();
		try {
			Card cardToDelete = cardService.findByPan(deleteRequest.getPan());
			if(cardToDelete.getValidationNumber() == deleteRequest.getValidationNumber()) {
				cardService.delete(cardToDelete);
				deleteResponse.setResponseCode("00");
				deleteResponse.setMessage("Se ha eliminado la tarjeta");
			}
		}catch(Exception e) {
			deleteResponse.setResponseCode("01");
			deleteResponse.setMessage("No se ha eliminado la tarjeta");
		}
		return deleteResponse;
	}

	private String maskPAN(String pan) {
		int panLength = pan.length();
		String firstDigits = pan.substring(0, 6);
		String lastDigits = pan.substring(panLength-4);
		String maskedDigits = pan.substring(6,panLength-4).replaceAll("\\d", "*");
		return firstDigits+maskedDigits+lastDigits;
	}

	private int generateValidationNumber() {
		int max = 100;
		int min = 1;
		return (int) (Math.random()*(max-min+1)+min);
	}

}
