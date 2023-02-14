package com.opzpy123.zweb3.chatgpt;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChatTest {

    @Test
    public static void main(String[] args) {
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik1UaEVOVUpHTkVNMVFURTRNMEZCTWpkQ05UZzVNRFUxUlRVd1FVSkRNRU13UmtGRVFrRXpSZyJ9.eyJodHRwczovL2FwaS5vcGVuYWkuY29tL3Byb2ZpbGUiOnsiZW1haWwiOiIxNDQxMTIwOTczQHFxLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJnZW9pcF9jb3VudHJ5IjoiVVMifSwiaHR0cHM6Ly9hcGkub3BlbmFpLmNvbS9hdXRoIjp7InVzZXJfaWQiOiJ1c2VyLVp0YURHWGdQaGtseDBRVXVGZ09JZ1NBYiJ9LCJpc3MiOiJodHRwczovL2F1dGgwLm9wZW5haS5jb20vIiwic3ViIjoiYXV0aDB8NjM5MDA1ZGU0MjE5NWM5MWE3NmY4ODIxIiwiYXVkIjpbImh0dHBzOi8vYXBpLm9wZW5haS5jb20vdjEiLCJodHRwczovL29wZW5haS5vcGVuYWkuYXV0aDBhcHAuY29tL3VzZXJpbmZvIl0sImlhdCI6MTY3NjI3NzQ1MCwiZXhwIjoxNjc3NDg3MDUwLCJhenAiOiJUZEpJY2JlMTZXb1RIdE45NW55eXdoNUU0eU9vNkl0RyIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwgbW9kZWwucmVhZCBtb2RlbC5yZXF1ZXN0IG9yZ2FuaXphdGlvbi5yZWFkIG9mZmxpbmVfYWNjZXNzIn0.VgbdzWii3VWCP5Wtkxsgc6FwweGsz4h_EqSJz-NUU7b2P1ojkJYbbHbBw7RnISsYWRTX6utAN1Z50pKySEiW7_Qt7T_Uk4djO4WbcevE8qn3fLbQbD99P2HvV535_uxdUCMqzFiZMQ58RoJDn9nZf9yNmRv3m1Hp9vws2BiS5PocQuxL0tWz1XeRJs4du-BL56y_--sl2bYFh6dLk2H2iK2fEjRysxk_xPnHhFMKSbYvqumm2nT8e69bu9e0WARy1sENmr6nqf8XHKWX-qHRIWBbg78H9TMJsWtnMsNVgAmMPnLfa09kaTmko6VDXC29I8-ccBhabC-WMjBBPwtSRg";
        OpenAiService service = new OpenAiService(token);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("你好")
                .model("text-davinci-003")
                .echo(true)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}
