package com.ai.resumeanalyzer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GrokService {

    @Value("${grok.api.key}")
    private String apiKey;

    private static final String GROK_API_URL =
            "https://api.x.ai/v1/chat/completions";

    private final RestTemplate restTemplate;

    public GrokService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @SuppressWarnings("unchecked")
    public String callGrok(String prompt) {

        // Debug: Log the API key being used
        System.out.println("DEBUG: Using API key: " + (apiKey != null ? apiKey.substring(0, Math.min(20, apiKey.length())) + "..." : "NULL"));

        // Validate API key
        if (apiKey == null || apiKey.isEmpty() || apiKey.contains("$")) {
            throw new RuntimeException("GROK_API_KEY environment variable not set or invalid. Set it before starting the app.");
        }

        // Request body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "grok-2-latest");
        requestBody.put("messages", List.of(
                Map.of("role", "user", "content", prompt)
        ));
        requestBody.put("temperature", 0.2);

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(requestBody, headers);

        try {
            // API Call
            ResponseEntity<Map> response = restTemplate.exchange(
                    GROK_API_URL,
                    HttpMethod.POST,
                    entity,
                    Map.class
            );

            // Extract response
            Map<String, Object> body = response.getBody();
            if (body == null) {
                throw new RuntimeException("Empty response from Grok API");
            }

            List<Map<String, Object>> choices =
                    (List<Map<String, Object>>) body.get("choices");

            if (choices == null || choices.isEmpty()) {
                throw new RuntimeException("No choices in Grok API response");
            }

            Map<String, Object> message =
                    (Map<String, Object>) choices.get(0).get("message");

            return message.get("content").toString();
        } catch (Exception e) {
            throw new RuntimeException("Grok API call failed: " + e.getMessage(), e);
        }
    }
}
