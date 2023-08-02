package com.opzpy123.zweb3.web.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TokenInfoDto {
    private String token;
    private String userId;
    private String userName;
    private Date expiredDate;

}
