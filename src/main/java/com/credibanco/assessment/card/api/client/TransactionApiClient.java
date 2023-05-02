package com.credibanco.assessment.card.api.client;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.credibanco.assessment.card.dto.TransactionCancelRequestDTO;
import com.credibanco.assessment.card.dto.TransactionCancelResponseDTO;
import com.credibanco.assessment.card.dto.TransactionCreationRequestDTO;
import com.credibanco.assessment.card.dto.TransactionCreationResponseDTO;

public class TransactionApiClient {

    private final String baseUrl;
    private final RestTemplate restTemplate;

    public TransactionApiClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.restTemplate = new RestTemplate();
    }

    public TransactionCreationResponseDTO createTransaction(TransactionCreationRequestDTO request) {
        String url = baseUrl + "/api/transactions";
        return restTemplate.postForObject(url, request, TransactionCreationResponseDTO.class);
    }

    public TransactionCancelResponseDTO cancelTransaction(String referenceNumber, TransactionCancelRequestDTO request) {
        String url = baseUrl + "/api/transactions/" + referenceNumber;
        return restTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(request), TransactionCancelResponseDTO.class).getBody();
    }
}