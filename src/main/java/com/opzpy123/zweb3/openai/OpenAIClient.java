package com.opzpy123.zweb3.openai;

import cn.hutool.json.JSONUtil;
import com.opzpy123.zweb3.openai.dto.OpenAIResp;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class OpenAIClient {
    @Value("${openAI.chatGPT.api-key}")
    public String apiKey;
    @Value("${openAI.chatGPT.model}")
    public String model;

    @SneakyThrows
    public OpenAIResp chatGPT(String prompt) {
        String authorization = "Bearer " + apiKey;
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        HashMap<String, Object> params = new HashMap<>();
        params.put("model", model);
        params.put("prompt", prompt);
        params.put("temperature", 0);
        params.put("max_tokens", 100);

        String content = JSONUtil.toJsonStr(params);
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/completions")
                .method("POST", body)
                .addHeader("Authorization", authorization)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            assert response.body() != null;
            String responseJson = response.body().string();
            OpenAIResp openAIResp = JSONUtil.toBean(responseJson, OpenAIResp.class);
            log.info("chat请求成功:{}", openAIResp);
            return openAIResp;
        } else {
            log.error("chat请求失败:{}", response);
            throw new RuntimeException("chat请求失败");
        }
    }

}
