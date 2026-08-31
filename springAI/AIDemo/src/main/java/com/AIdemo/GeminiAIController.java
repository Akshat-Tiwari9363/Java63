package com.AIdemo;

import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/openai")
@CrossOrigin
public class GeminiAIController {

    private GoogleGenAiChatModel chatModel;

    public GeminiAIController(GoogleGenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message) {
        String response=chatModel.call(message);
        return ResponseEntity.ok(response);
    }
    

}
