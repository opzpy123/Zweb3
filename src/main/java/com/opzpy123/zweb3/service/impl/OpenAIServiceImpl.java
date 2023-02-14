package com.opzpy123.zweb3.service.impl;

import com.opzpy123.zweb3.openai.OpenAIClient;
import com.opzpy123.zweb3.openai.dto.OpenAIResp;
import com.opzpy123.zweb3.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("openAIService")
public class OpenAIServiceImpl implements OpenAIService {

    @Autowired
    protected OpenAIClient openAIClient;

    @Override
    public OpenAIResp chat(String prompt) {
        OpenAIResp openAIResp = openAIClient.chatGPT(prompt);
        return openAIResp;
    }
}
