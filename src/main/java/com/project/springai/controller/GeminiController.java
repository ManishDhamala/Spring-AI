package com.project.springai.controller;

import com.project.springai.model.Answer;
import com.project.springai.model.Question;
import com.project.springai.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class GeminiController {

    private final GeminiService geminiService;

    @Autowired
    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/ask")
    public Answer ask(@RequestBody Question question) {

        if (question.getQuestion() != null) {
            System.out.println("Given Prompt: " + question.getQuestion());
            String ans = geminiService.askQuestionGetAnswer(question.getQuestion());
            return new Answer(ans);
        }
        return null;
    }
}

