package com.opzpy123.zweb3.rabbitmq;

import cn.hutool.core.util.IdUtil;
import com.opzpy123.zweb3.web.model.ActUser;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitmqTest {

    @Autowired
    protected RabbitTemplate rabbitTemplate;
    @Autowired
    protected org.springframework.amqp.core.Queue queue;

    @Test
    public void test() {
        ActUser actUser = new ActUser();
        actUser.setId(IdUtil.fastSimpleUUID());
        actUser.setUserName("opzpy123");
        rabbitTemplate.convertAndSend(queue.getName(), actUser);
    }
}
