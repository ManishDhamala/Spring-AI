package com.project.springai.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    @Value("${genai.api.key}")
    private String apiKey;

    @Value("${genai.model}")
    private String model;

    public String askQuestionGetAnswer(String prompt) {

        // Construct client with API key
        Client client = Client.builder()
                .apiKey(apiKey)
                .build();

        // Send request
        GenerateContentResponse response = client.models.generateContent(model, prompt, null);

        // Extract response text
        return response.text();
    }
}

