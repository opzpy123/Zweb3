package com.opzpy123.zweb3.service;

import com.opzpy123.zweb3.web.model.ActUser;
import com.opzpy123.zweb3.web.service.ActUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class ActUserServiceTest {
    @Autowired
    ActUserService actUserService;

    @Test
    public void actUserServiceTest() {
        ActUser actUser = new ActUser();
        actUser.setUserName("admin");
        actUser.setUserPassword("opzpy123");
        actUserService.save(actUser);
        List<ActUser> list = actUserService.list();
        System.out.println(list);
    }
}
