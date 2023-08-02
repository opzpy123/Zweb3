package com.opzpy123.zweb3.kafka;

import com.opzpy123.zweb3.component.kafka.conf.KafkaConf;
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
        kafkaTemplate.send(KafkaConf.topic, "hello");
    }
}
