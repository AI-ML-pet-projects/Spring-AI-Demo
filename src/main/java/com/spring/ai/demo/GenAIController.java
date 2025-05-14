package com.spring.ai.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenAIController {
    @Autowired
    private ChatService chatService;

    @GetMapping("ask")
    public String ask(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }
}
