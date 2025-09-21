package com.project.springai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class GeminiController {

    private final GeminiService geminiService;

    @Autowired
    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    // Inner class
    public static class AskRequest {
        public String question;
        // optionally other fields like model override etc
    }

    // Inner class
    public static class AskResponse {
        public String answer;
        public AskResponse(String answer) {
            this.answer = answer;
        }
    }

    @PostMapping("/ask")
    public AskResponse ask(@RequestBody AskRequest request) {
        String ans = geminiService.askQuestion(request.question);
        return new AskResponse(ans);
    }
}

