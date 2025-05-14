package com.spring.ai.demo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeService {
    @Autowired
    private ChatModel chatModel;

    public String getRecipe(String ingredients, String cuisine, String dietaryRestrictions) {
        PromptTemplate promptTemplate = getPromptTemplate();

        Map<String, Object> map = new HashMap<>();
        map.put("ingredients", ingredients);
        map.put("cuisine", cuisine);
        map.put("dietaryRestrictions", dietaryRestrictions);

        Prompt prompt = promptTemplate.create(map);
        return chatModel.call(prompt).getResult().getOutput().getText();
    }

    private static PromptTemplate getPromptTemplate() {
        String template = """
                I’d like a recipe using the following ingredients: {ingredients}
                Please make sure it fits the {cuisine} style and follows these dietary restrictions: {dietaryRestrictions}.
                
                Format the response with:
                - Title
                - Macros
                - Ingredients list
                - Step-by-step instructions
                """;

        return new PromptTemplate(template);
    }
}
