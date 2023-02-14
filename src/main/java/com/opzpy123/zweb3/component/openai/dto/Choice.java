package com.opzpy123.zweb3.component.openai.dto;

import lombok.Data;

@Data
public class Choice {
    private String text;
    private Integer index;
    private Object logprobs;
    private String finish_reason;
}
