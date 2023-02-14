package com.opzpy123.zweb3.chatgpt;

import com.opzpy123.zweb3.service.OpenAIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChatTest {
    @Autowired
    OpenAIService openAIService;

    @Test
    public void test() {
        openAIService.chat("hello");
    }
}
