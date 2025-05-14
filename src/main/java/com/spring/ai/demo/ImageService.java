package com.spring.ai.demo;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageModel imageModel;

    public String getImage(String prompt) {
        ImageResponse imageResponse = imageModel.call(
                new ImagePrompt(
                        prompt,
                        OpenAiImageOptions.builder()
                                .quality("hd")
//                                .N(4)
                                .height(1024)
                                .width(1024)
                                .build()
                )
        );
        return imageResponse.getResult().getOutput().getUrl();
    }
}
