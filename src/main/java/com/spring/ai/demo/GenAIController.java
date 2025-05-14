package com.spring.ai.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class GenAIController {
    @Autowired
    private ChatService chatService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping("ask")
    public String ask(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }

    @GetMapping("/image")
    public String genImage(@RequestParam String prompt) {
        return imageService.getImage(prompt);
    }

    @GetMapping("/recipe")
    public String genRecipe(@RequestParam String ingredients,
                            @RequestParam(defaultValue = "any") String cuisine,
                            @RequestParam(required = false) String dietaryRestrictions) {
        return recipeService.getRecipe(ingredients, cuisine, dietaryRestrictions);
    }
}
