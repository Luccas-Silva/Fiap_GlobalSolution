package com.fiap.Java_GlobalSolution.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ask")
    public Map<String, String> askAi(@RequestParam String prompt) {
        String resposta = this.chatClient.prompt().user(prompt).call().content();
        return Map.of("resposta", resposta);
    }

    @PostMapping("/chat")
    public Map<String, String> chatAi(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        String resposta = this.chatClient.prompt().user(prompt).call().content();
        return Map.of("resposta", resposta);
    }
}