package com.opzpy123.zweb3.service;

import com.opzpy123.zweb3.component.openai.dto.OpenAIResp;

public interface OpenAIService {

    /**
     * chatGPT chat
     *
     * @param prompt 语句
     * @return  请求结果
     */
    OpenAIResp chat(String prompt);
}
