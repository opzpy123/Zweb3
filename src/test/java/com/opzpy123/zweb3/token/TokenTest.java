package com.opzpy123.zweb3.token;

import com.opzpy123.zweb3.service.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TokenTest {
    @Autowired
    TokenService tokenService;

    @Test
    public void test() {
//        String token = tokenService.generateToken("admin", 1000 * 60 * 3);
        Boolean valid = tokenService.validateToken("admin", "ad75ccf6-8058-41a8-b233-3df890398064");
        System.out.println(valid);
    }
}
