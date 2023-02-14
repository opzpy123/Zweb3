package com.opzpy123.zweb3.openai.dto;

import lombok.Data;

import java.util.List;

@Data
public class OpenAIResp {
    private String id;
    private String object;
    private Long created;
    private String model;
    private List<Choice> choices;
    private Object usage;
}
