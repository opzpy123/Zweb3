package com.opzpy123.zweb3.kafka;

import cn.hutool.core.util.IdUtil;
import com.opzpy123.zweb3.model.ActUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
public class KafkaMsgTest {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @Test
    public void sendMsg() {
        ActUser actUser = new ActUser();
        actUser.setId(IdUtil.fastSimpleUUID());
        actUser.setUserName("hhhh");
        kafkaTemplate.send("web3Topic", actUser);
    }
}
