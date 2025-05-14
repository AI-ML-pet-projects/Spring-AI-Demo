package com.spring.ai.demo;

import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AudioTranscriberService {

    @Autowired
    private OpenAiAudioTranscriptionModel audioTranscriptionModel;

    public String transcribe(MultipartFile audioFile) {

        OpenAiAudioTranscriptionOptions transcriptionOptions = OpenAiAudioTranscriptionOptions.builder()
                .language("en")
                .prompt("Ask not this, but ask that")
                .temperature(0f)
                .responseFormat(OpenAiAudioApi.TranscriptResponseFormat.TEXT)
                .build();
        AudioTranscriptionPrompt transcriptionRequest = new AudioTranscriptionPrompt(audioFile.getResource(), transcriptionOptions);
        AudioTranscriptionResponse response = audioTranscriptionModel.call(transcriptionRequest);
        return response.getResult().getOutput();
    }
}
