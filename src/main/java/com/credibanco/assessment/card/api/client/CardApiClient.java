package com.credibanco.assessment.card.api.client;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.credibanco.assessment.card.dto.CardConsultResponseDTO;
import com.credibanco.assessment.card.dto.CardCreationRequestDTO;
import com.credibanco.assessment.card.dto.CardCreationResponseDTO;
import com.credibanco.assessment.card.dto.CardDeleteRequestDTO;
import com.credibanco.assessment.card.dto.CardDeleteResponseDTO;
import com.credibanco.assessment.card.dto.CardEnrollRequestDTO;
import com.credibanco.assessment.card.dto.CardEnrollResponseDTO;

public class CardApiClient {

    private final String baseUrl;
    private final RestTemplate restTemplate;

    public CardApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.restTemplate = new RestTemplate();
    }

    public CardCreationResponseDTO createCard(CardCreationRequestDTO request) {
        String url = baseUrl + "/api/cards";
        return restTemplate.postForObject(url, request, CardCreationResponseDTO.class);
    }

    public CardEnrollResponseDTO enrollCard(String pan, CardEnrollRequestDTO request) {
        String url = baseUrl + "/api/cards/" + pan + "/enroll";
        return restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(request), CardEnrollResponseDTO.class).getBody();
    }

    public CardConsultResponseDTO consultCard(String pan) {
        String url = baseUrl + "/api/cards/" + pan;
        return restTemplate.getForObject(url, CardConsultResponseDTO.class);
    }

    public CardDeleteResponseDTO deleteCard(String pan, CardDeleteRequestDTO request) {
        String url = baseUrl + "/api/cards/" + pan;
        return restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(request), CardDeleteResponseDTO.class).getBody();
    }
}